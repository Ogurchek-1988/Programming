package clientCommands;

import client.ClientApplication;
import command.RequiringArg;
import connection.ClientConnectionManager;
import exceptions.NoArgException;
import exceptions.ScriptRecursionException;
import input.ScriptInputManager;
import inputManager.InputManager;
import messages.Messenger;
import output.OutputManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class ExecuteScriptCommand implements ClientCommand, RequiringArg<String>{
    private final DatagramSocket socket;
    private final SocketAddress address;
    private final OutputManager outputManager;
    private final Messenger messenger;
    private final ClientApplication app;
    private String arg;

    public ExecuteScriptCommand(DatagramSocket socket, SocketAddress address, OutputManager outputManager,
                                Messenger messenger, ClientApplication app){
        this.socket = socket;
        this.address = address;
        this.outputManager = outputManager;
        this.messenger = messenger;
        this.app = app;
    }

    @Override
    public String execute() {
        try{
            InputManager inputManager = new ScriptInputManager(new BufferedReader(new InputStreamReader(new FileInputStream(arg))), messenger);
            ClientCommandManager commandManager = new ClientCommandManagerImpl(socket,address,inputManager,outputManager,messenger,app);
            if (commandManager.scriptIsUsed(arg)){
                commandManager.clearUsedScripts();
                throw new ScriptRecursionException();
            }
            commandManager.usedScriptAdd(arg);
            while (inputManager.ready()){
                try{
                    String inputString = inputManager.readCommand();
                    String[] input = inputString.split("\\s+",2);
                    if (input.length < 2)
                        commandManager.executeCommand(input[0],"");
                    else
                        commandManager.executeCommand(input[0],input[1]);
                } catch (IOException e){
                    outputManager.printErrorMsg(messenger.getMesseng("script") + "\n");
                    return "";
                }
            }
            commandManager.usedScriptRemove(arg);
        } catch (IOException e){
            outputManager.printErrorMsg(messenger.getMesseng("noFile") + "\n");
        }
        return messenger.getMesseng("scriptOutput");
    }

    @Override
    public void setArg(String arg) {
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(ClientCommandInvoker commandInvoker) throws NoArgException{
        commandInvoker.setStringArgToCommand(this);
        commandInvoker.invokeCommand(this);
    }
}

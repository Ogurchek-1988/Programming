package commands;

import input.ServerConsoleCommandReader;
import inputManager.CommandReader;
import messages.Messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ServerCommandsReader extends Thread implements CommandsReader{
    private boolean exit;
    private final CommandReader commandReader;
    private final Messenger messenger;
    private final ServerCommandManager commandManager;

    public ServerCommandsReader(ServerCommandManager commandManager, Messenger messenger){
        this.commandManager = commandManager;
        this.messenger = messenger;
        commandReader = new ServerConsoleCommandReader(new BufferedReader(new InputStreamReader(System.in)));
    }

    @Override
    public void run() {
        while (!exit){
            try{
                String inputString = commandReader.readCommand();
                if (inputString.equals("")) continue;
                commandManager.executeServerCommand(inputString);
            } catch (IOException e){
                e.printStackTrace();
                stopReading();
            }
        }
    }

    @Override
    public void startReading() {
        start();
    }

    @Override
    public void stopReading() {
        exit = true;
    }
}

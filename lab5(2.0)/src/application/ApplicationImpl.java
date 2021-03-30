package application;

import collectionManager.CollectionManager;
import collectionManager.SpaceMarineCollectionManager;
import commands.CommandManager;
import commands.CommandManagerImpl;
import exceptions.*;
import fileManager.*;
import input.ConsoleInputManager;
import input.InputManager;
import messeges.*;
import output.ConsoleOutputManager;
import output.OutputManager;

import java.util.NoSuchElementException;

public class ApplicationImpl implements Application{
    private boolean exit;
    private OutputManager outputManager;
    private InputManager inputManager;
    private Messenger messenger;
    private CommandManager commandManager;

    public ApplicationImpl(){
        exit = false;
    }

    @Override
    public void start(String fileName){
        messenger = new MessengerImpl(new RuCommandMessages(), new EngExceptionMessages(), new EngSpaceMarineCollectionMessages());
        outputManager = new ConsoleOutputManager();
        inputManager = new ConsoleInputManager(messenger,outputManager);
        DataReader dataReader = new CSVSpaceMarineReader(fileName);
        DataWriter dataWriter = new CSVSpaceMarineWriter(fileName);
        DataManager dataManager = new DataManagerImpl(dataReader,dataWriter,messenger);
        CollectionManager collectionManager = new SpaceMarineCollectionManager(dataManager);
        try{
            collectionManager.loadSpaceMarine();
        } catch (NoEnvVarException | InvalidArgumentException | NoDataException | BrokenDataException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
        }
        this.commandManager = new CommandManagerImpl(collectionManager, this, messenger, outputManager, inputManager);
        outputManager.printMsg(messenger.getStartMsg() + "\n");
        run();
        outputManager.printMsg(messenger.getFinishMsg());
    }

    private void run(){
        while (!exit){
            try{
                String inputString = inputManager.readCommand();
                String[] input = inputString.split("\\s+", 2);
                if (input.length < 2)
                    commandManager.executeCommand(input[0], "");
                else
                    commandManager.executeCommand(input[0],input[1]);
            } catch (NoSuchCommandException | ScriptRecursionException e){
                outputManager.printErrorMsg(e.getMessage() + "\n");
            } catch (NoSuchElementException e){
                outputManager.printErrorMsg(messenger.getExceptionMsg("NoSuchElement") + "\n");
                exit();
            }
        }
    }

    @Override
    public void exit(){
        exit = true;
    }


}

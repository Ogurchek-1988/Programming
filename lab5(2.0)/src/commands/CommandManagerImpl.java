package commands;

import application.Application;
import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import exceptions.NoSuchCommandException;
import input.InputManager;
import messeges.Messenger;
import output.OutputManager;

import java.util.*;

public class CommandManagerImpl implements CommandManager{
    private Map<String, Command> commandMap;
    private static Set<String> usedScripts = new HashSet<>();
    private CommandInvoker commandInvoker;
    private Messenger messenger;
    private OutputManager outputManager;

    public CommandManagerImpl(CollectionManager collectionManager, Application app, Messenger messenger, OutputManager outputManager, InputManager inputManager){
        this.outputManager = outputManager;
        this.messenger = messenger;
        commandMap = new HashMap<>();
        commandInvoker = new CommandInvokerImpl(messenger);
        commandMap.put("help", new HelpCommand(commandMap.keySet(), messenger, outputManager));
        commandMap.put("info", new InfoCommand(collectionManager, messenger, outputManager));
        commandMap.put("show", new ShowCommand(collectionManager,messenger,outputManager));
        commandMap.put("add", new AddCommand(collectionManager,inputManager));
        commandMap.put("update", new UpdateCommand(collectionManager,messenger,inputManager,outputManager));
        commandMap.put("remove_by_id", new RemoveByIdCommand(collectionManager,messenger,outputManager));
        commandMap.put("clear", new ClearCommand(collectionManager));
        commandMap.put("save", new SaveCommand(collectionManager));
        commandMap.put("execute_script", new ExecuteScriptCommand(messenger,outputManager,collectionManager,app));
        commandMap.put("exit", new ExitCommand(app));
        commandMap.put("add_if_min", new AddIfMinCommand(collectionManager,inputManager));
        commandMap.put("remove_greater", new RemoveGreaterCommand(collectionManager,inputManager));
        commandMap.put("remove_lower", new RemoveLowerCommand(collectionManager, inputManager));
        commandMap.put("sum_of_height", new SumOfHeightCommand(collectionManager,messenger,outputManager));
        commandMap.put("max_by_health", new MaxByHealthCommand(collectionManager,messenger,outputManager));
        commandMap.put("filter_contains_name", new FilterContainsNameCommand(collectionManager,messenger,outputManager));
    }

    @Override
    public void executeCommand(String command, String arg) throws NoSuchCommandException {
        if (command.equals(""))
            return;
        if (commandMap.containsKey(command)){
            commandInvoker.setArg(arg);
            try{
                commandMap.get(command).acceptInvoker(commandInvoker);
            } catch (NoArgException | InvalidArgumentTypeException e){
                outputManager.printErrorMsg(e.getMessage() + "\n");
                return;
            }
        } else {
            throw new NoSuchCommandException(messenger.getExceptionMsg("noSuchCommand") + ": " + command);
        }
    }

    @Override
    public void usedScriptAdd(String scriptName){
        usedScripts.add(scriptName);
    }

    @Override
    public boolean scriptIsUsed(String scriptName){
        return usedScripts.contains(scriptName);
    }

    @Override
    public void usedScriptRemove(String scriptName){
        usedScripts.remove(scriptName);
    }

    @Override
    public void clearUsedScripts(){
        usedScripts.clear();
    }
}

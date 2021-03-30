package commands;

import collectionManager.CollectionManager;
import exceptions.NoArgException;
import messeges.Messenger;
import output.OutputManager;

public class FilterContainsNameCommand implements Command, RequiringArg<String>{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;
    private String arg;

    public FilterContainsNameCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute(){
        collectionManager.getSpaceMarineStream().filter(spaceMarine -> spaceMarine.getName().contains(arg)).forEachOrdered(spaceMarine -> outputManager.printMsg(messenger.getSpaceMarineString(spaceMarine) + "\n"));
    }

    @Override
    public void setArg(String arg){
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(CommandInvoker commandInvoker) throws NoArgException {
        commandInvoker.setStringArg(this);
        commandInvoker.invokeCommand(this);
    }
}

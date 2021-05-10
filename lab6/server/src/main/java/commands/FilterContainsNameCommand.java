package commands;

import collectionManager.CollectionManager;
import command.RequiringArg;
import exceptions.NoArgException;
import messages.Messenger;

public class FilterContainsNameCommand implements ServerCommand, RequiringArg<String> {
    private CollectionManager collectionManager;
    private Messenger messenger;
    private String arg;

    public FilterContainsNameCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messenger.getMesseng("filterContainsNameOutput")).append("\n");
        collectionManager.getSpaceMarineStream().filter(spaceMarine -> spaceMarine.getName().contains(arg)).forEachOrdered(spaceMarine -> stringBuilder.append(spaceMarine).append("\n"));
        return stringBuilder.toString();
    }

    @Override
    public void setArg(String arg){
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(ServerCommandInvoker commandInvoker) throws NoArgException {
        commandInvoker.setStringArgToCommand(this);
        commandInvoker.invokeCommand(this);
    }
}

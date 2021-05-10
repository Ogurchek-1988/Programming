package commands;

import collectionManager.CollectionManager;
import messages.Messenger;


public class ShowCommand implements ServerCommand {
    private CollectionManager collectionManager;
    private Messenger messenger;

    public ShowCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messenger.getMesseng("showOutput"))
                .append(" (")
                .append(collectionManager.getSize())
                .append("):\n");
        collectionManager.getSpaceMarineStream()
                .forEachOrdered(spaceMarine -> stringBuilder.append(spaceMarine).append("\n"));
        return stringBuilder.toString();
    }
}

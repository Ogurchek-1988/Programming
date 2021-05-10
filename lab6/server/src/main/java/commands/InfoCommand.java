package commands;

import collectionManager.CollectionManager;
import messages.Messenger;


public class InfoCommand implements ServerCommand {
    private CollectionManager collectionManager;
    private Messenger messenger;

    public InfoCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messenger.getMesseng("collectionType"))
                .append(": ")
                .append(collectionManager.getType().getSimpleName())
                .append("\n")
                .append(messenger.getMesseng("collectionInitDate"))
                .append(": ")
                .append(collectionManager.getInitDate())
                .append("\n")
                .append(messenger.getMesseng("collectionSize"))
                .append(": ")
                .append(collectionManager.getSize());
        return stringBuilder.toString();
    }
}

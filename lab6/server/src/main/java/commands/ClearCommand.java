package commands;

import collectionManager.CollectionManager;
import messages.Messenger;

public class ClearCommand implements ServerCommand {
    private final CollectionManager collectionManager;
    private final Messenger messenger;

    public ClearCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute(){
        collectionManager.clear();
        return messenger.getMesseng("clearOutput");
    }
}

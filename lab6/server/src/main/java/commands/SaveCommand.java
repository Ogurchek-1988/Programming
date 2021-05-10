package commands;

import collectionManager.CollectionManager;
import messages.Messenger;

public class SaveCommand implements ServerCommand {
    private final CollectionManager collectionManager;
    private final Messenger messenger;

    public SaveCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute()   {
        collectionManager.saveSpaceMarine();
        return messenger.getMesseng("saveOutput");
    }
}

package commands;

import collectionManager.CollectionManager;
import messages.Messenger;
import spaceMarine.SpaceMarine;


public class RemoveLowerCommand implements ServerCommand {
    private CollectionManager collectionManager;
    private Messenger messenger;

    public RemoveLowerCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute() {
        SpaceMarine spaceMarine = collectionManager.getSpaceMarineStream().min(SpaceMarine::compareTo).get();
        collectionManager.removeElement(spaceMarine);
        return messenger.getMesseng("removeLowerOutput");
    }
}

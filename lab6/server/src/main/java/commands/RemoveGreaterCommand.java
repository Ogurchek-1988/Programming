package commands;

import collectionManager.CollectionManager;
import messages.Messenger;
import spaceMarine.RawSpaceMarine;
import spaceMarine.SpaceMarine;

import java.util.Iterator;

public class RemoveGreaterCommand implements ServerCommand {
    private CollectionManager collectionManager;
    private Messenger messenger;
    private RawSpaceMarine spaceMarine;

    public RemoveGreaterCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute(){
        SpaceMarine spaceMarine = collectionManager.getSpaceMarineStream().max(SpaceMarine::compareTo).get();
        collectionManager.removeElement(spaceMarine);
        return messenger.getMesseng("removeGreaterOutput");
    }
}

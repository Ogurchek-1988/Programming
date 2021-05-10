package commands;

import collectionManager.CollectionManager;
import messages.Messenger;

import java.util.Comparator;

public class MaxByHealthCommand implements ServerCommand {
    private CollectionManager collectionManager;
    private Messenger messenger;
    public MaxByHealthCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute(){
        return messenger.getMesseng("maxByHealthOutput") + ":\n" + collectionManager.getSpaceMarineStream().max(Comparator.comparingInt(o -> o.getHealth())).get();
    }
}

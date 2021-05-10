package commands;

import collectionManager.CollectionManager;
import messages.Messenger;
import spaceMarine.RawSpaceMarine;
import spaceMarine.SpaceMarine;

import java.util.stream.Collectors;


public class SumOfHeightCommand implements ServerCommand {
    private CollectionManager collectionManager;
    private Messenger messenger;
    private RawSpaceMarine spaceMarine;

    public SumOfHeightCommand(CollectionManager collectionManager,Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute() {
        return collectionManager.getSpaceMarineStream().collect(Collectors.summingInt(SpaceMarine::getHeight)).toString();
    }
}

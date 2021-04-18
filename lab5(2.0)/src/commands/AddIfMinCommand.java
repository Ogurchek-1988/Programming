package commands;

import collectionManager.CollectionManager;
import input.InputManager;
import spaceMarine.SpaceMarine;

import java.util.HashMap;
import java.util.Map;

public class AddIfMinCommand implements Command{
    private CollectionManager collectionManager;
    private InputManager inputManager;

    public AddIfMinCommand(CollectionManager collectionManager, InputManager inputManager){
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
    }

    @Override
    public void execute(){
        SpaceMarine spaceMarine = inputManager.readSpaceMarine();
        if (spaceMarine.compareTo(collectionManager.getSpaceMarineStream().min(SpaceMarine::compareTo).get()) <= 0)
            collectionManager.addElement(spaceMarine);
    }

}

package commands;

import collectionManager.CollectionManager;
import input.InputManager;
import spaceMarine.SpaceMarine;

import java.util.Iterator;

public class RemoveLowerCommand implements Command{
    private CollectionManager collectionManager;
    private InputManager inputManager;
    private Iterator<SpaceMarine> iterator;

    public RemoveLowerCommand(CollectionManager collectionManager, InputManager inputManager){
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
    }

    @Override
    public void execute(){
        SpaceMarine spaceMarine = inputManager.readSpaceMarine();
        iterator = collectionManager.getIterator();
        while (iterator.hasNext()) {
            if (iterator.next().compareTo(spaceMarine) > 0){
                iterator.remove();
            }
        }
    }
}

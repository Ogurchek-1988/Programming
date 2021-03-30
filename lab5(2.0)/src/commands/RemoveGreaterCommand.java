package commands;

import collectionManager.CollectionManager;
import input.InputManager;
import messeges.Messenger;
import spaceMarine.SpaceMarine;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RemoveGreaterCommand implements Command{
    private CollectionManager collectionManager;
    private Iterator<SpaceMarine> iterator;
    private InputManager inputManager;

    public RemoveGreaterCommand(CollectionManager collectionManager, InputManager inputManager){
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;

    }

    @Override
    public void execute(){
        SpaceMarine spaceMarine = inputManager.readSpaceMarine();
        iterator = collectionManager.getIterator();
        while (iterator.hasNext()) {
            if (iterator.next().compareTo(spaceMarine) < 0){
                iterator.remove();
            }
        }
    }
}

package commands;

import collectionManager.CollectionManager;
import input.InputManager;

public class AddCommand implements Command{
    private InputManager inputManager;
    private CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager, InputManager inputManager){
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
    }

    @Override
    public void execute() {
        collectionManager.addElement(inputManager.readSpaceMarine());
    }
}

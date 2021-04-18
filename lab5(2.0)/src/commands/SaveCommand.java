package commands;

import collectionManager.CollectionManager;

import java.util.HashMap;
import java.util.Map;

public class SaveCommand implements Command{
    private CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(){
        collectionManager.saveSpaceMarine();
    }
}

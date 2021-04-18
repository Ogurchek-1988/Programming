package commands;

import collectionManager.CollectionManager;

import java.util.HashMap;
import java.util.Map;

public class ClearCommand implements Command{
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(){
        collectionManager.clear();
    }
}

package commands;

import collectionManager.CollectionManager;

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

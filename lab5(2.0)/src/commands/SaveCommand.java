package commands;

import collectionManager.CollectionManager;

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

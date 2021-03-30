package commands;

import collectionManager.CollectionManager;
import messeges.Messenger;
import output.OutputManager;

public class ShowCommand implements Command{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;

    public ShowCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute(){
        collectionManager.getSpaceMarineStream().forEachOrdered(spaceMarine -> outputManager.printMsg(messenger.getSpaceMarineString(spaceMarine) + "\n"));
    }
}

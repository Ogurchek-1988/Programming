package commands;

import collectionManager.CollectionManager;
import messeges.Messenger;
import output.OutputManager;

public class InfoCommand implements Command{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;

    public InfoCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute(){
        outputManager.printMsg(messenger.getCollectionTypeMsg() + ":" + collectionManager.getType().getSimpleName() +
        "\n" + messenger.getCollectionInitDateMsg() + ":" + collectionManager.getInitDate() +
        "\n" + messenger.getCollectionSizeMsg() + ":" + collectionManager.getSize() + "\n");
    }
}

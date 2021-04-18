package commands;

import collectionManager.CollectionManager;
import messeges.Messenger;
import output.OutputManager;

import java.util.HashMap;
import java.util.Map;

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
        outputManager.printMsg(messenger.getMesseng("collectionType") + ":" + collectionManager.getType().getSimpleName() +
        "\n" + messenger.getMesseng("collectionInitDate") + ":" + collectionManager.getInitDate() +
        "\n" + messenger.getMesseng("collectionSize") + ":" + collectionManager.getSize() + "\n");
    }
}

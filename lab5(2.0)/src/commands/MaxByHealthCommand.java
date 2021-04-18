package commands;

import collectionManager.CollectionManager;
import messeges.Messenger;
import output.OutputManager;

import java.util.Comparator;

public class MaxByHealthCommand implements Command{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;
    public MaxByHealthCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute(){
        outputManager.printMsg(messenger.getSpaceMarineString(collectionManager.getSpaceMarineStream().max(Comparator.comparingInt(o -> o.getHealth())).get()) + "\n");
    }
}

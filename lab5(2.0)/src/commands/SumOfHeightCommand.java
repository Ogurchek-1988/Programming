package commands;

import collectionManager.CollectionManager;
import messeges.Messenger;
import output.OutputManager;
import spaceMarine.SpaceMarine;

import java.util.Iterator;

public class SumOfHeightCommand implements Command{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;

    public SumOfHeightCommand(CollectionManager collectionManager,Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute(){
        Iterator<SpaceMarine> iterator = collectionManager.getIterator();
        int sum = 0;
        while (iterator.hasNext())
            sum += iterator.next().getHeight();
        outputManager.printMsg(sum + "");

    }
}

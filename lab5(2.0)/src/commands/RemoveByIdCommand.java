package commands;

import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import messeges.Messenger;
import output.OutputManager;

import java.util.HashMap;
import java.util.Map;

public class RemoveByIdCommand implements Command, RequiringArg<Long>{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;
    private long arg;

    public RemoveByIdCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute(){
        if(!collectionManager.removeElement(arg)){
            outputManager.printErrorMsg(messenger.getMesseng("noSuchId") + "\n");
        }
    }

    @Override
    public void setArg(Long arg){
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(CommandInvoker commandInvoker) throws NoArgException, InvalidArgumentTypeException{
        commandInvoker.setLongArg(this);
        commandInvoker.invokeCommand(this);
    }
}

package commands;

import collectionManager.CollectionManager;
import collectionManager.SpaceMarineIdManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import input.InputManager;
import messeges.Messenger;
import output.OutputManager;
import spaceMarine.SpaceMarine;

public class UpdateCommand implements Command, RequiringArg<Long>{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private InputManager inputManager;
    private OutputManager outputManager;
    private long arg;

    public UpdateCommand(CollectionManager collectionManager, Messenger messenger, InputManager inputManager, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public void execute() {
        if (!SpaceMarineIdManager.getInstance().idIsFree(arg)){
            SpaceMarineIdManager.getInstance().removeId(arg);
            SpaceMarine oldSpaceMarine = collectionManager.getSpaceMarineStream().filter(spaceMarine -> spaceMarine.getId() == arg).findAny().get();
            SpaceMarine spaceMarine = inputManager.readSpaceMarine(oldSpaceMarine.getId(), oldSpaceMarine.getCreationDate());
            collectionManager.removeElement(arg);
            collectionManager.addElement(spaceMarine);
        } else{
            outputManager.printErrorMsg(messenger.getExceptionMsg("NoSuchId") + "\n");
        }
    }

    @Override
    public void setArg(Long arg){
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(CommandInvoker commandInvoker) throws NoArgException, InvalidArgumentTypeException {
        commandInvoker.setLongArg(this);
        commandInvoker.invokeCommand(this);
    }
}

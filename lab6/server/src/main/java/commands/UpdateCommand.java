package commands;

import collectionManager.CollectionManager;
import collectionManager.SpaceMarineIdManager;
import command.RequiringArg;
import exceptions.InvalidArgumentTypeException;
import exceptions.NeedObjectException;
import exceptions.NoArgException;
import inputManager.InputManager;
import messages.Messenger;
import spaceMarine.RawSpaceMarine;
import spaceMarine.SpaceMarine;

public class UpdateCommand implements ServerCommand, RequiringArg<Long>, RequiringObject{
    private final CollectionManager collectionManager;
    private final Messenger messenger;
    private long arg;
    private RawSpaceMarine spaceMarine;

    public UpdateCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute() {
        if (!SpaceMarineIdManager.getInstance().idIsFree(arg)){
            SpaceMarineIdManager.getInstance().removeId(arg);
            SpaceMarine oldSpaceMarine = collectionManager.getSpaceMarineStream().filter(spaceMarine -> spaceMarine.getId() == arg).findAny().get();
            SpaceMarine newSpaceMarine = new SpaceMarine(oldSpaceMarine.getId(), oldSpaceMarine.getCreationDate(), spaceMarine);
            collectionManager.removeElement(arg);
            collectionManager.addElement(spaceMarine);
            return messenger.getMesseng("updateOutput");
        } else {
            return messenger.getMesseng("notUpdateOutput");
        }
    }

    @Override
    public void setArg(Long arg){
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(ServerCommandInvoker commandInvoker) throws NoArgException, InvalidArgumentTypeException, NeedObjectException {
        commandInvoker.setLongArgToCommand(this);
        commandInvoker.setObjectToCommand(this);
        commandInvoker.invokeCommand(this);
    }

    @Override
    public void setObject(RawSpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }
}

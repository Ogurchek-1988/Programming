package commands;

import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NeedObjectException;
import exceptions.NoArgException;
import messages.Messenger;
import spaceMarine.RawSpaceMarine;
import spaceMarine.SpaceMarine;

public class AddIfMinCommand implements ServerCommand, RequiringObject{
    private final CollectionManager collectionManager;
    private final Messenger messenger;
    private RawSpaceMarine spaceMarine;

    public AddIfMinCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute(){
        if (spaceMarine.compareTo(collectionManager.getSpaceMarineStream().min(SpaceMarine::compareTo).get().getRawSpaceMarine()) <= 0) {
            collectionManager.addElement(spaceMarine);
            return messenger.getMesseng("addOutput");
        } else {
            return messenger.getMesseng("noAddOutput");
        }
    }

    @Override
    public void acceptInvoker(ServerCommandInvoker commandInvoker) throws NoArgException, InvalidArgumentTypeException, NeedObjectException {
        commandInvoker.setObjectToCommand(this);
        commandInvoker.invokeCommand(this);
    }

    @Override
    public void setObject(RawSpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }

}

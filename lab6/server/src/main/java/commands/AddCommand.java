package commands;

import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NeedObjectException;
import exceptions.NoArgException;
import messages.Messenger;
import spaceMarine.RawSpaceMarine;

public class AddCommand implements ServerCommand, RequiringObject {
    private final Messenger messenger;
    private final CollectionManager collectionManager;
    private RawSpaceMarine spaceMarine;

    public AddCommand(CollectionManager collectionManager, Messenger messenger){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute() {
        collectionManager.addElement(spaceMarine);
        return messenger.getMesseng("addOutput");
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

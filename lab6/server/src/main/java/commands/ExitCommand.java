package commands;

import collectionManager.CollectionManager;
import messages.Messenger;
import server.Application;

public class ExitCommand implements ServerCommand {
    private final Application app;
    private final CollectionManager collectionManager;
    private final Messenger messenger;

    public
    ExitCommand(CollectionManager collectionManager, Application app, Messenger messenger){
        this.app = app;
        this.collectionManager = collectionManager;
        this.messenger = messenger;
    }

    @Override
    public String execute(){
        collectionManager.saveSpaceMarine();
        app.exit();
        return messenger.getMesseng("exitOutput");
    }
}

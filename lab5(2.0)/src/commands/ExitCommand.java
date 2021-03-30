package commands;

import application.Application;

public class ExitCommand implements Command{
    private Application app;

    public ExitCommand(Application app){
        this.app = app;
    }

    @Override
    public void execute(){
        app.exit();
    }
}

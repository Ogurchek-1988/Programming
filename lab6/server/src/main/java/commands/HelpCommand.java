package commands;

import exceptions.NoSuchCommandException;
import messages.Messenger;


import java.util.Set;

public class HelpCommand implements ServerCommand {
    private final Set<String> commands;
    private Messenger messenger;

    public HelpCommand(Set<String> commands, Messenger messenger){
        this.commands = commands;
        this.messenger = messenger;
    }

    @Override
    public String execute(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messenger.getMesseng("helpOutput")).append(":\n");
        commands.stream().forEach(command -> stringBuilder.append(messenger.getMesseng(command+"Description")).append("\n"));
        return stringBuilder.toString();
    }
}

package input;

import inputManager.CommandReader;
import inputManager.InputManager;
import inputManager.SpaceMarineReader;
import messages.Messenger;
import spaceMarine.RawSpaceMarine;
import spaceMarine.SpaceMarine;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;

/**
 * реализация интерфейса InputManager
 */
public class ScriptInputManager implements InputManager {
    private BufferedReader reader;
    private CommandReader commandReader;
    private SpaceMarineReader spaceMarineReader;

    public ScriptInputManager(BufferedReader reader, Messenger messenger){
        this.reader = reader;
        commandReader = new ScriptCommandReader(reader);
        spaceMarineReader = new ScriptSpaceMarineReader(reader);
    }

    @Override
    public boolean ready(){
        try {
            return reader.ready();
        } catch (IOException e){
            return false;
        }
    }

    @Override
    public String readCommand() throws IOException{
        return commandReader.readCommand();
    }

    @Override
    public RawSpaceMarine readSpaceMarine() throws IOException{
        return spaceMarineReader.readSpaceMarine();
    }
}

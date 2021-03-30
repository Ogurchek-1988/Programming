package input;

import messeges.Messenger;
import spaceMarine.SpaceMarine;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;

public class ScriptInputManager implements InputManager{
    private BufferedReader reader;
    private CommandReader commandReader;
    private SpaceMarineReader spaceMarineReader;

    public ScriptInputManager(BufferedReader reader, Messenger messenger){
        this.reader = reader;
        commandReader = new ScriptCommandReader(reader, messenger);
        spaceMarineReader = new ScriptSpaceMarineReader(reader, messenger);
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
    public String readCommand(){
        return commandReader.readCommand();
    }

    @Override
    public SpaceMarine readSpaceMarine(){
        return spaceMarineReader.readSpaceMarine();
    }

    @Override
    public SpaceMarine readSpaceMarine(long id, ZonedDateTime creationDate){
        return spaceMarineReader.readSpaceMarine(id, creationDate);
    }

}

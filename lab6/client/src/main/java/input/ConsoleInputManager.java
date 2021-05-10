package input;

import inputManager.CommandReader;
import inputManager.InputManager;
import inputManager.SpaceMarineReader;
import messages.Messenger;
import output.OutputManager;
import spaceMarine.RawSpaceMarine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * реализация интерфейса InputManager
 */
public class ConsoleInputManager implements InputManager {
    private final BufferedReader reader;
    private final CommandReader commandReader;
    private final SpaceMarineReader spaceMarineReader;

    public ConsoleInputManager(Messenger messenger, OutputManager outputManager){
        reader = new BufferedReader(new InputStreamReader(System.in));
        commandReader = new ConsoleCommandReader(reader);
        spaceMarineReader = new ConsoleSpaceMarineReader(reader, messenger, outputManager);
    }

    @Override
    public boolean ready() throws IOException {
        return reader.ready();
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

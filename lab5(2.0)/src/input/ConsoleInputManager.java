package input;

import messeges.Messenger;
import output.OutputManager;
import spaceMarine.SpaceMarine;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class ConsoleInputManager implements InputManager{
    private Scanner scanner;
    private CommandReader commandReader;
    private SpaceMarineReader spaceMarineReader;

    public ConsoleInputManager(Messenger messenger, OutputManager outputManager){
        scanner = new Scanner(System.in);
        commandReader = new ConsoleCommandReader(scanner);
        spaceMarineReader = new ConsoleSpaceMarineReader(scanner, outputManager, messenger);
    }

    @Override
    public boolean ready(){
        return scanner.hasNext();
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

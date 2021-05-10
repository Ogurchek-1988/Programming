package inputManager;

import spaceMarine.RawSpaceMarine;

import java.io.IOException;

public interface InputManager {
    boolean ready() throws IOException;
    String readCommand() throws IOException;
    RawSpaceMarine readSpaceMarine() throws IOException;
}

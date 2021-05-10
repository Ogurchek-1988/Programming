package inputManager;

import spaceMarine.RawSpaceMarine;
import java.io.IOException;

public interface SpaceMarineReader {
    RawSpaceMarine readSpaceMarine() throws IOException;
}

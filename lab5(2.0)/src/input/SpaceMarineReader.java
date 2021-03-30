package input;

import spaceMarine.SpaceMarine;

import java.time.ZonedDateTime;

public interface SpaceMarineReader {

    SpaceMarine readSpaceMarine();

    SpaceMarine readSpaceMarine(long id, ZonedDateTime creationDate);

}

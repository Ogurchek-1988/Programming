package input;

import spaceMarine.SpaceMarine;

import java.time.ZonedDateTime;

/**
 *  Интерфейс класса считывания элементов коллекции
 */
public interface SpaceMarineReader {

    SpaceMarine readSpaceMarine();

    SpaceMarine readSpaceMarine(long id, ZonedDateTime creationDate);

}

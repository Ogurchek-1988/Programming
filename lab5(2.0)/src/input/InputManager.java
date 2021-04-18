package input;

import spaceMarine.SpaceMarine;

import java.time.ZonedDateTime;

/**
 * интерфейс менеджера ввода
 */
public interface InputManager {

    boolean ready();

    String readCommand();

    SpaceMarine readSpaceMarine();

    SpaceMarine readSpaceMarine(long id, ZonedDateTime creationDate);
}

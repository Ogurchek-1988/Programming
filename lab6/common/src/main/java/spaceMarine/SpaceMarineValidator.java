package spaceMarine;

import java.time.ZonedDateTime;

/**
 * интерфейс валидатора класса SpaceMarine
 */
public interface SpaceMarineValidator {
    boolean validateId(long id);
    boolean validateName(String name);
    boolean validateCoordinates(Coordinates coordinates);
    boolean validateCreationDate(ZonedDateTime creationDate);
    boolean validateHealth(Integer health);
    boolean validateHeartCount(Integer heartCount);
    boolean validateWeaponType(Weapon weaponType);

}

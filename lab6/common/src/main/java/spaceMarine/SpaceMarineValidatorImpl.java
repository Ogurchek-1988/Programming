package spaceMarine;

import java.time.ZonedDateTime;

/**
 * валидатор класса SpaceMarine
 */
public class SpaceMarineValidatorImpl implements SpaceMarineValidator {
    @Override
    public boolean validateId(long id) {
        return id > 0;
    }

    @Override
    public boolean validateName(String name) {
        return name != null && !name.equals("");
    }

    @Override
    public boolean validateCoordinates(Coordinates coordinates) {
        return coordinates != null;
    }

    @Override
    public boolean validateCreationDate(ZonedDateTime creationDate) {
        return creationDate != null;
    }

    @Override
    public boolean validateHealth(Integer health) {
        return health > 0 && health != null;
    }

    @Override
    public boolean validateHeartCount(Integer heartCount) {
        return heartCount > 0 && heartCount <= 3;
    }

    @Override
    public boolean validateWeaponType(Weapon weaponType) {
        return weaponType != null;
    }
}

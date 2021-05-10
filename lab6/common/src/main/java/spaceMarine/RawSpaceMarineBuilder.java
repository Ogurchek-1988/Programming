package spaceMarine;

import exceptions.InvalidArgumentException;

import java.time.ZonedDateTime;

/**
 * интерфейс строитель класса SpaceMarine
 */
public interface RawSpaceMarineBuilder {

    void setName(String name) throws InvalidArgumentException;
    void setCoordinatesX(Integer x) throws InvalidArgumentException;
    void setCoordinatesY(long y);
    void setHealth(Integer health) throws InvalidArgumentException;
    void setHeartCount(Integer heartCount) throws InvalidArgumentException;
    void setHeight(int height);
    void setWeaponType(Weapon weaponType) throws InvalidArgumentException;
    void setChapterName(String name) throws InvalidArgumentException;
    void setChapterWorld(String world) throws InvalidArgumentException;
    RawSpaceMarine getRawSpaceMarine();
}

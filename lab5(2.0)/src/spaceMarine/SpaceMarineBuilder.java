package spaceMarine;

import exceptions.InvalidArgumentException;

import java.time.ZonedDateTime;

public interface SpaceMarineBuilder {
    void setId();
    void setId(long id) throws InvalidArgumentException;
    void setName(String name) throws InvalidArgumentException;
    void setCoordinatesX(Integer x) throws InvalidArgumentException;
    void setCoordinatesY(long y);
    void setCreationDate(ZonedDateTime creationDate) throws InvalidArgumentException;
    void setHealth(Integer health) throws InvalidArgumentException;
    void setHeartCount(Integer heartCount) throws InvalidArgumentException;
    void setHeight(int height);
    void setWeaponType(Weapon weaponType) throws InvalidArgumentException;
    void setChapterName(String name) throws InvalidArgumentException;
    void setChapterWorld(String world) throws InvalidArgumentException;
    SpaceMarine getSpaceMarine();
}

package spaceMarine;

import exceptions.*;
import messages.Messenger;

import java.time.Clock;
import java.time.ZonedDateTime;

public class RawSpaceMarineBuilderImpl implements RawSpaceMarineBuilder{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private CoordinatesBuilder coordinatesBuilder; //Поле не может быть null
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private Integer heartCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private int height;
    private Weapon weaponType; //Поле не может быть null
    private ChapterBuilder chapterBuilder; //Поле может быть null
    private final SpaceMarineValidator validator;

    public RawSpaceMarineBuilderImpl(){
        validator = new SpaceMarineValidatorImpl();
    }

    @Override
    public void setName(String name) throws InvalidNameException{
        if (validator.validateName(name)) {
            this.name = name;
        } else {
            throw new InvalidNameException();
        }
    }

    @Override
    public void setCoordinatesX(Integer x) throws InvalidCoordinatesXException {
        if (coordinatesBuilder == null) {
            coordinatesBuilder = new CoordinatesBuilderImpl();
        }
        coordinatesBuilder.setX(x);
    }

    @Override
    public void setCoordinatesY(long y) {
        if (coordinatesBuilder == null) {
            coordinatesBuilder = new CoordinatesBuilderImpl();
        }
        coordinatesBuilder.setY(y);
    }

    @Override
    public void setHealth(Integer health) throws InvalidHealthException {
        if (validator.validateHealth(health)) {
            this.health = health;
        } else {
            throw new InvalidHealthException();
        }
    }

    @Override
    public void setHeartCount(Integer heartCount) throws InvalidHeartCountException {
        if (validator.validateHeartCount(heartCount)) {
            this.heartCount = heartCount;
        } else {
            throw new InvalidHeartCountException();
        }
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWeaponType(Weapon weaponType) throws InvalidWeaponTypeException {
        if (validator.validateWeaponType(weaponType)) {
            this.weaponType = weaponType;
        } else {
            throw new InvalidWeaponTypeException();
        }
    }

    @Override
    public void setChapterName(String name) throws InvalidArgumentException {
        if (chapterBuilder == null) {
            chapterBuilder = new ChapterBuilderImpl();
        }
        chapterBuilder.setName(name);
    }

    @Override
    public void setChapterWorld(String world) {
        if (chapterBuilder == null) {
            chapterBuilder = new ChapterBuilderImpl();
        }
        chapterBuilder.setWorld(world);
    }

    @Override
    public RawSpaceMarine getRawSpaceMarine(){
        return new RawSpaceMarine(name,coordinatesBuilder.getCoordinates(),health,heartCount,height,weaponType,chapterBuilder.getChapter());
    }
}

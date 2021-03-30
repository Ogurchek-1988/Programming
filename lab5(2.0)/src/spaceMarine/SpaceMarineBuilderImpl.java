package spaceMarine;

import collectionManager.IdManager;
import collectionManager.SpaceMarineIdManager;
import exceptions.InvalidArgumentException;
import exceptions.NotUniqueIdExeption;

import java.time.Clock;
import java.time.ZonedDateTime;

public class SpaceMarineBuilderImpl implements SpaceMarineBuilder {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private CoordinatesBuilderImpl coordinatesBuilder; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private Integer heartCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private int height;
    private Weapon weaponType; //Поле не может быть null
    private ChapterBuilderImpl chapterBuilder; //Поле может быть null
    private SpaceMarineValidatorImpl validator;
    private IdManager idManager;

    public SpaceMarineBuilderImpl() {
        idManager = SpaceMarineIdManager.getInstance();
        validator = new SpaceMarineValidatorImpl();
    }

    @Override
    public void setId() {
        id = idManager.getFreeId();
    }

    @Override
    public void setId(long id) throws InvalidArgumentException {
        if (validator.validateId(id)) {
            if (idManager.idIsFree(id)) {
                this.id = id;
            } else {
                throw new NotUniqueIdExeption("");
            }
        } else {
            throw new InvalidArgumentException("");
        }
    }

    @Override
    public void setName(String name) throws InvalidArgumentException {
        if (validator.validateName(name)) {
            this.name = name;
        } else {
            throw new InvalidArgumentException("");
        }
    }

    @Override
    public void setCoordinatesX(Integer x) throws InvalidArgumentException {
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
    public void setCreationDate(ZonedDateTime creationDate) throws InvalidArgumentException {
        if (validator.validateCreationDate(creationDate)) {
            this.creationDate = creationDate;
        } else {
            throw new InvalidArgumentException("");
        }
    }

    @Override
    public void setHealth(Integer health) throws InvalidArgumentException {
        if (validator.validateHealth(health)) {
            this.health = health;
        } else {
            throw new InvalidArgumentException("");
        }
    }

    @Override
    public void setHeartCount(Integer heartCount) throws InvalidArgumentException {
        if (validator.validateHeartCount(heartCount)) {
            this.heartCount = heartCount;
        } else {
            throw new InvalidArgumentException("");
        }
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWeaponType(Weapon weaponType) throws InvalidArgumentException {
        if (validator.validateWeaponType(weaponType)) {
            this.weaponType = weaponType;
        } else {
            throw new InvalidArgumentException("");
        }
    }

    @Override
    public void setChapterName(String name) throws InvalidArgumentException {
        if (chapterBuilder == null) chapterBuilder = new ChapterBuilderImpl();
        chapterBuilder.setName(name);
    }

    @Override
    public void setChapterWorld(String world) {
        if (chapterBuilder == null) chapterBuilder = new ChapterBuilderImpl();
        chapterBuilder.setWorld(world);
    }

    @Override
    public SpaceMarine getSpaceMarine() {
        if (validator.validateCreationDate(creationDate)) {
            creationDate = ZonedDateTime.now(Clock.systemUTC());
        }
        idManager.addId(id);
        return new SpaceMarine(id, name, coordinatesBuilder.getCoordinates(), creationDate, health, heartCount, height, weaponType, chapterBuilder.getChapter());
    }
}

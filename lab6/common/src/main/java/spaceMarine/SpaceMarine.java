package spaceMarine;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Класс SpaceMarine
 */
public class SpaceMarine implements Comparable<SpaceMarine>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private Integer heartCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private int height;
    private Weapon weaponType; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public SpaceMarine(long id, ZonedDateTime creationDate, RawSpaceMarine rawSpaceMarine){
        this.id = id;
        this.name = rawSpaceMarine.getName();
        this.coordinates = rawSpaceMarine.getCoordinates();
        this.creationDate = creationDate;
        this.health = rawSpaceMarine.getHealth();
        this.heartCount = rawSpaceMarine.getHeartCount();
        this.height = rawSpaceMarine.getHeight();
        this.weaponType = rawSpaceMarine.getWeaponType();
        this.chapter = rawSpaceMarine.getChapter();
    }
    public long getId(){

        return id;
    }

    public String getName(){

        return name;
    }

    public Coordinates getCoordinates(){

        return coordinates;
    }

    public ZonedDateTime getCreationDate(){

        return creationDate;
    }

    public Integer getHealth(){

        return health;
    }

    public Integer getHeartCount(){

        return heartCount;
    }

    public int getHeight(){

        return height;
    }

    public Weapon getWeaponType(){

        return weaponType;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public RawSpaceMarine getRawSpaceMarine(){
        return new RawSpaceMarine(getName(),getCoordinates(),getHealth(),getHeartCount(),getHeight(),getWeaponType(),getChapter());
    }
    @Override
    public int compareTo(SpaceMarine s){
        return getName().compareTo(s.getName());
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceMarine spaceMarine = (SpaceMarine) o;
        return id == spaceMarine.id && height == spaceMarine.height && name.equals(spaceMarine.name) && coordinates.equals(spaceMarine.coordinates)
                && creationDate.equals(spaceMarine.creationDate) && health == spaceMarine.health && weaponType == spaceMarine.weaponType
                && chapter.equals(spaceMarine.chapter);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name,coordinates,creationDate,health,heartCount,height,weaponType,chapter);
    }

    @Override
    public String toString(){
        return String.format("SpaceMarine(id=%d,name=%s,coordinates=%s,creationDate=%s,health=%d,heartCount=%d,height=%d,weaponType=%s,chapter=%s)",
                id,name,coordinates,creationDate,health,heartCount,height,weaponType,chapter);
    }
}

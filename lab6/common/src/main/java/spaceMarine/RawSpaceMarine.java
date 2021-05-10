package spaceMarine;

import java.io.Serializable;
import java.util.Objects;

public class RawSpaceMarine implements Comparable<RawSpaceMarine>, Serializable{
    private static final long serialVersionUID = 5366370939317668205L;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private Integer heartCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private int height;
    private Weapon weaponType; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public RawSpaceMarine(String name, Coordinates coordinates, Integer health, Integer heartCount, int height, Weapon weaponType, Chapter chapter){
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.heartCount = heartCount;
        this.height = height;
        this.weaponType = weaponType;
        this.chapter = chapter;
    }

    public String getName(){

        return name;
    }

    public Coordinates getCoordinates(){

        return coordinates;
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

    @Override
    public boolean equals(Object o ){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawSpaceMarine rawSpaceMarine = (RawSpaceMarine) o;
        return height == rawSpaceMarine.height && name.equals(rawSpaceMarine.name) && coordinates.equals(rawSpaceMarine.coordinates)
                && health == rawSpaceMarine.health && heartCount == rawSpaceMarine.heartCount && weaponType == rawSpaceMarine.weaponType
                && chapter.equals(rawSpaceMarine.chapter);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,coordinates,health,heartCount,height,weaponType,chapter);
    }

    @Override
    public String toString(){
        return String.format("SpaceMarine(name=%s,coordinates=%s,health=%d,heartCount=%d,height=%d,weaponType=%s,chapter=%s)",
                name,coordinates,health,heartCount,height,weaponType,chapter);
    }

    @Override
    public int compareTo(RawSpaceMarine o){
        return getName().compareTo(o.getName());
    }
}

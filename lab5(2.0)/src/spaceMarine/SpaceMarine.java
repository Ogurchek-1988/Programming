package spaceMarine;

import java.time.ZonedDateTime;

public class SpaceMarine implements Comparable<SpaceMarine>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health; //Поле может быть null, Значение поля должно быть больше 0
    private Integer heartCount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private int height;
    private Weapon weaponType; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public SpaceMarine(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer health, Integer heartCount, int height, Weapon weaponType, Chapter chapter){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.heartCount = heartCount;
        this.weaponType = weaponType;
        this.chapter = chapter;
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
    @Override
    public int compareTo(SpaceMarine s){
        int result = Integer.compare(health, s.health);
        if (result != 0 ){
            return result;
        }
        return Long.compare(id,s.id);
    }

}

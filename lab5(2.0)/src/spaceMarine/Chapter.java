package spaceMarine;
/**
 * Класс Chapter
 */
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String world; //Поле может быть null
    public Chapter(String name, String world){
        this.name = name;
        this.world = world;
    }
    public String getName(){
        return name;
    }
    public String getWorld(){
        return world;
    }
}

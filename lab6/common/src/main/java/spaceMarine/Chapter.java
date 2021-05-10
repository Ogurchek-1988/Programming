package spaceMarine;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс Chapter
 */
public class Chapter implements Serializable {
    private static final long serialVersionUID =  -418147180688417077L;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter that = (Chapter) o;
        return world == that.world && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,world);
    }

    @Override
    public String toString() {
        return String.format("Chapter(name=%s,world=%s)",name,world);
    }
}

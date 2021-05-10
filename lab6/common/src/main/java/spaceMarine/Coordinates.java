package spaceMarine;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс координат
 */
public class Coordinates implements Serializable {
    private static final long serialVersionUID = 1610850390120831496L;
    private Integer x; //Значение поля должно быть больше -941, Поле не может быть null
    private long y;

    public Coordinates(Integer x, long y) {
        this.x = x;
        this.y = y;
    }
    public Integer getX(){
        return x;
    }
    public long getY(){
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return y == that.y && x.equals(that.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public String toString() {
        return String.format("Coordinates(x=%d,y=%d)",x,y);
    }
}

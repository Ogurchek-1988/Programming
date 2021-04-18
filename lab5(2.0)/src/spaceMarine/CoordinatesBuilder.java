package spaceMarine;

import exceptions.InvalidArgumentException;
/**
 * интерфейс класса строитель координат
 */
public interface CoordinatesBuilder {
    void setX(Integer x) throws InvalidArgumentException;
    void setY(long y);
    Coordinates getCoordinates();
}

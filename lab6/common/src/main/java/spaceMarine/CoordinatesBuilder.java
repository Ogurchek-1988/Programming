package spaceMarine;

import exceptions.InvalidCoordinatesXException;

/**
 * интерфейс класса строитель координат
 */
public interface CoordinatesBuilder {
    void setX(Integer x) throws InvalidCoordinatesXException;
    void setY(long y);
    Coordinates getCoordinates();
}

package spaceMarine;

import exceptions.InvalidArgumentException;

public interface CoordinatesBuilder {
    void setX(Integer x) throws InvalidArgumentException;
    void setY(long y);
    Coordinates getCoordinates();
}

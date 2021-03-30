package spaceMarine;

import exceptions.InvalidArgumentException;

public class CoordinatesBuilderImpl implements CoordinatesBuilder {
    private Integer x; //Значение поля должно быть больше -941, Поле не может быть null
    private long y;
    CoordinatesValidatorImpl validator;
    public CoordinatesBuilderImpl() {
        validator = new CoordinatesValidatorImpl();
    }
    public void setX(Integer x) throws InvalidArgumentException {
        if (validator.validateX(x)){
            this.x = x;
        } else {
            throw new InvalidArgumentException("invalid coordinates x");
        }
    }
    public void setY(long y){
        this.y = y;
    }
    public Coordinates getCoordinates(){
        return new Coordinates(x,y);
    }
}

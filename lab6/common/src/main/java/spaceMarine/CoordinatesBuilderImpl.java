package spaceMarine;


import exceptions.InvalidCoordinatesXException;

/**
 * Класс строитель координат
 */
public class CoordinatesBuilderImpl implements CoordinatesBuilder {
    private Integer x; //Значение поля должно быть больше -941, Поле не может быть null
    private long y;
    private final CoordinatesValidator validator;
    public CoordinatesBuilderImpl() {
        validator = new CoordinatesValidatorImpl();
    }

    @Override
    public void setX(Integer x) throws InvalidCoordinatesXException {
        if (validator.validateX(x)){
            this.x = x;
        } else {
            throw new InvalidCoordinatesXException();
        }
    }

    @Override
    public void setY(long y){
        this.y = y;
    }
    @Override
    public Coordinates getCoordinates(){
        return new Coordinates(x,y);
    }
}

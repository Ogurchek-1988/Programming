package spaceMarine;


import exceptions.InvalidArgumentException;
import messeges.Messenger;
/**
 * Класс строитель координат
 */
public class CoordinatesBuilderImpl implements CoordinatesBuilder {
    private Integer x; //Значение поля должно быть больше -941, Поле не может быть null
    private long y;
    private Messenger messenger;
    CoordinatesValidatorImpl validator;
    public CoordinatesBuilderImpl(Messenger messenger) {
        this.messenger = messenger;
        validator = new CoordinatesValidatorImpl();
    }
    public void setX(Integer x) throws InvalidArgumentException {
        if (validator.validateX(x)){
            this.x = x;
        } else {
            throw new InvalidArgumentException(messenger.getMesseng("invalidCoordinatesX"));
        }
    }
    public void setY(long y){
        this.y = y;
    }
    public Coordinates getCoordinates(){
        return new Coordinates(x,y);
    }
}

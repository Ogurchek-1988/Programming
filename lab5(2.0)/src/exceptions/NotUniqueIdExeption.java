package exceptions;

public class NotUniqueIdExeption extends InvalidArgumentException{
    public NotUniqueIdExeption(String msg){
        super(msg);
    }
}

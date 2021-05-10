package spaceMarine;
/**
 * Класс валидатор координат
 */
public class CoordinatesValidatorImpl implements CoordinatesValidator {
    @Override
    public boolean validateX(Integer x){
        return x >-941 && x != null;
    }
}

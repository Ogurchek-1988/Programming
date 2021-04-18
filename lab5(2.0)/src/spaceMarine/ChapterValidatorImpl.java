package spaceMarine;
/**
 * Класс валидации Chapter
 */
public class ChapterValidatorImpl implements ChapterValidator {
    @Override
    public boolean validateName(String name) {
        return name != null && !name.equals("");
    }
}

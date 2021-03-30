package spaceMarine;

public class ChapterValidatorImpl implements ChapterValidator {
    @Override
    public boolean validateName(String name) {
        return name != null && !name.equals("");
    }
}

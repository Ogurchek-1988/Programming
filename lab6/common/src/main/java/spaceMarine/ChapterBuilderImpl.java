package spaceMarine;

import exceptions.InvalidChapterNameException;

/**
 * строитель Chapter
 */
public class ChapterBuilderImpl implements ChapterBuilder {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String world; //Поле может быть null
    private final ChapterValidator validator;

    public ChapterBuilderImpl(){
        validator = new ChapterValidatorImpl();
    }

    @Override
    public void setName(String name) throws InvalidChapterNameException {
        if (validator.validateName(name)){
            this.name = name;
        } else{
            throw new InvalidChapterNameException();
        }
    }
    @Override
    public void setWorld(String world){
        this.world = world;
    }

    @Override
    public Chapter getChapter(){
        return new Chapter(name,world);
    }
}

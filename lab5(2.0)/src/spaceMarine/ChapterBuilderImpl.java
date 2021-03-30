package spaceMarine;

import exceptions.InvalidArgumentException;

public class ChapterBuilderImpl implements ChapterBuilder {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String world; //Поле может быть null
    ChapterValidatorImpl validator;

    public ChapterBuilderImpl(){
        validator = new ChapterValidatorImpl();
    }
    public void setName(String name) throws InvalidArgumentException {
        if (validator.validateName(name)){
            this.name = name;
        } else{
            throw new InvalidArgumentException("invalid chapter name");
        }
    }
    public void setWorld(String world){
        this.world = world;
    }
    public Chapter getChapter(){
        return new Chapter(name,world);
    }
}

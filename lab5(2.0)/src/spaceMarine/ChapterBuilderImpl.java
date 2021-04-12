package spaceMarine;

import exceptions.InvalidArgumentException;
import messeges.Messenger;

public class ChapterBuilderImpl implements ChapterBuilder {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String world; //Поле может быть null
    private Messenger messenger;
    ChapterValidatorImpl validator;

    public ChapterBuilderImpl(Messenger messenger){
        this.messenger = messenger;
        validator = new ChapterValidatorImpl();
    }
    public void setName(String name) throws InvalidArgumentException {
        if (validator.validateName(name)){
            this.name = name;
        } else{
            throw new InvalidArgumentException(messenger.getExceptionMsg("invalidChapterName"));
        }
    }
    public void setWorld(String world){
        this.world = world;
    }
    public Chapter getChapter(){
        return new Chapter(name,world);
    }
}

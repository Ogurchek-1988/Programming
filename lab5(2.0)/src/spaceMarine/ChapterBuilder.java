package spaceMarine;

import exceptions.InvalidArgumentException;

public interface ChapterBuilder {
    void setName(String name) throws InvalidArgumentException;
    void setWorld(String world);
}

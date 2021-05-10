package spaceMarine;

import exceptions.InvalidArgumentException;

/**
 * интерфейс класса строитель Chapter
 */
public interface ChapterBuilder {
    void setName(String name) throws InvalidArgumentException;
    void setWorld(String world);
    Chapter getChapter();
}

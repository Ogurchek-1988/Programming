package collectionManager;

import com.sun.source.tree.Tree;
import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import exceptions.NoEnvVarException;
import spaceMarine.SpaceMarine;

import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Stream;

public interface CollectionManager {
    Class getType();
    int getSize();
    ZonedDateTime getInitDate();
    void addElement(SpaceMarine spaceMarine);
    boolean removeElement(long id);
    void clear();
    void loadSpaceMarine() throws InvalidArgumentException, NoDataException, BrokenDataException, NoEnvVarException;
    void saveSpaceMarine();
    Stream<SpaceMarine> getSpaceMarineStream();
    Iterator<SpaceMarine> getIterator();
    TreeSet<SpaceMarine> getSpaceMarines();
}

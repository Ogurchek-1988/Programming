package fileManager;

import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import spaceMarine.SpaceMarine;

import java.util.Collection;
import java.util.TreeSet;

public interface DataManager {
    Collection<? extends SpaceMarine> readElements() throws InvalidArgumentException, NoDataException, BrokenDataException;
    void writeElements(TreeSet<SpaceMarine> collection);
}

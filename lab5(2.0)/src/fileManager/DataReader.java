package fileManager;

import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import spaceMarine.SpaceMarine;

import java.util.Collection;

public interface DataReader {
    Collection<? extends SpaceMarine> readElements() throws InvalidArgumentException, NoDataException, BrokenDataException;
}

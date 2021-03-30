package fileManager;

import spaceMarine.SpaceMarine;

import java.util.Collection;

public interface DataWriter {
    void writeElements(Collection<? extends SpaceMarine> collection);
}

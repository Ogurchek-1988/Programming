package dataManager;

import spaceMarine.SpaceMarine;

import java.util.TreeSet;

public interface DataWriter {
    void writeElements(TreeSet<SpaceMarine> collection);
}

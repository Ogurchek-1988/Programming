package collectionManager;

import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import exceptions.NoEnvVarException;
import fileManager.DataManager;
import spaceMarine.SpaceMarine;

import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SpaceMarineCollectionManager implements CollectionManager{
    private ZonedDateTime initDate;
    private TreeSet<SpaceMarine> spaceMarineTreeSet;
    private DataManager dataManager;

    public SpaceMarineCollectionManager(DataManager dataManager){
        initDate = ZonedDateTime.now();
        spaceMarineTreeSet = new TreeSet<>();
        this.dataManager = dataManager;
    }

    @Override
    public Class getType() {
        return spaceMarineTreeSet.getClass();
    }

    @Override
    public int getSize() {
        return spaceMarineTreeSet.size();
    }

    @Override
    public ZonedDateTime getInitDate() {
        return initDate;
    }

    @Override
    public void addElement(SpaceMarine spaceMarine) {
        spaceMarineTreeSet.add(spaceMarine);
    }

    @Override
    public boolean removeElement(long id) {
        for (SpaceMarine spaceMarine: spaceMarineTreeSet) {
            if (spaceMarine.getId() == id) {
                SpaceMarineIdManager.getInstance().removeId(id);
                spaceMarineTreeSet.remove(spaceMarine);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        SpaceMarineIdManager.getInstance().clearIdentifiers();
        spaceMarineTreeSet.clear();
    }

    @Override
    public void loadSpaceMarine() throws InvalidArgumentException, NoDataException, BrokenDataException, NoEnvVarException {
        spaceMarineTreeSet.addAll(dataManager.readElements());
    }

    @Override
    public void saveSpaceMarine() {
        dataManager.writeElements(spaceMarineTreeSet);
    }

    @Override
    public Stream<SpaceMarine> getSpaceMarineStream() {
        return spaceMarineTreeSet.stream();
    }

    @Override
    public Iterator<SpaceMarine> getIterator() {
        return spaceMarineTreeSet.iterator();
    }
}

package collectionManager;

import java.util.Set;
import java.util.TreeSet;

public class SpaceMarineIdManager implements IdManager{
    private Set<Integer> usedIdentifiers;
    private static SpaceMarineIdManager instance;

    public synchronized static SpaceMarineIdManager getInstance(){
        if (instance == null){
            instance = new SpaceMarineIdManager();
        }
        return instance;
    }

    private SpaceMarineIdManager(){
        usedIdentifiers = new TreeSet<>();
    }

    @Override
    public boolean idIsFree(long id) {
        return !usedIdentifiers.contains(id);
    }

    @Override
    public long getFreeId() {
        long prevId = 0L;
        for (long id: usedIdentifiers) {
            if (id - prevId != 1) {
                break;
            }
            prevId = id;
        }
        return prevId + 1;
    }

    @Override
    public void addId(long id) {
        usedIdentifiers.add((int) id);
    }

    @Override
    public void removeId(long id) {
        usedIdentifiers.remove(id);
    }

    @Override
    public void clearIdentifiers() {
        usedIdentifiers.clear();
    }
}

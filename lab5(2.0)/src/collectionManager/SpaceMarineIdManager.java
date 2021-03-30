package collectionManager;
import java.util.Set;
import  java.util.TreeSet;

public class SpaceMarineIdManager implements IdManager{
    private Set<Long> usedIdentifiers;
    private static SpaceMarineIdManager instance;

    public synchronized static SpaceMarineIdManager getInstance(){
        if(instance == null){
            instance = new SpaceMarineIdManager();
        }
        return instance;
    }
    private SpaceMarineIdManager(){
        usedIdentifiers = new TreeSet<>();
    }

    @Override
    public boolean idIsFree(long id){
        return !usedIdentifiers.contains(id);
    }

    @Override
    public long getFreeId(){
        long pervId = 0;
        for (long id: usedIdentifiers){
            if (id - pervId != 1){
                break;
            }
            pervId = id;
        }
        return pervId + 1;
    }

    @Override
    public void addId(long id){
        usedIdentifiers.add(id);
    }

    @Override
    public void removeId(long id){
        usedIdentifiers.remove(id);
    }

    @Override
    public void clearIdentifiers(){
        usedIdentifiers.clear();
    }
}

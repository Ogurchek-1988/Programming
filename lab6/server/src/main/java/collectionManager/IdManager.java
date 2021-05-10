package collectionManager;

public interface IdManager{
    boolean idIsFree(long id);
    long getFreeId();
    void addId(long id);
    void removeId(long id);
    void clearIdentifiers();
}

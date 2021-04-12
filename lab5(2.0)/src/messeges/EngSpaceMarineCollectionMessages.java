package messeges;

import spaceMarine.SpaceMarine;

public class EngSpaceMarineCollectionMessages implements CollectionMessages {
    private final String collectionTypeMsg;
    private final String collectionInitDateMsg;
    private final String collectionSizeMsg;
    private final String inputNameMsg;
    private final String inputCoordinatesXMsg;
    private final String inputCoordinatesYMsg;
    private final String inputHealthMsg;
    private final String inputHeartCountMsg;
    private final String inputHeightMsg;
    private final String inputWeaponTypeMsg;
    private final String inputChapterNameMsg;
    private final String inputChapterWorldMsg;

    public EngSpaceMarineCollectionMessages() {
        collectionTypeMsg = "Collection type";
        collectionInitDateMsg = "Initialization date";
        collectionSizeMsg = "Number of elements";
        inputNameMsg = "Name";
        inputCoordinatesXMsg = "coordinates.x";
        inputCoordinatesYMsg = "coordinates.y";
        inputHealthMsg = "health";
        inputHeartCountMsg = "heart count [1;3]";
        inputHeightMsg = "height";
        inputWeaponTypeMsg = "weaponType (BOLTGUN, HEAVY_BOLTGUN, PLASMA_GUN, MULTI_MELTA)";
        inputChapterNameMsg = "chapter.Name";
        inputChapterWorldMsg = "chapter.World";
    }

    @Override
    public String getSpaceMarineString(SpaceMarine spaceMarine) {
        return String.format("id=%d; name=%s; coordinates=(%d, %d); creationDate=%s; health=%d; heartCount=%d; " +
                        "height=%d; weaponType=%s; chapterName=%s, chapterWorld=%s", spaceMarine.getId(), spaceMarine.getName(), spaceMarine.getCoordinates().getX(), spaceMarine.getCoordinates().getY(),
                spaceMarine.getCreationDate(), spaceMarine.getHealth(), spaceMarine.getHeartCount(), spaceMarine.getHeight(),
                spaceMarine.getWeaponType(), spaceMarine.getChapter().getName(), spaceMarine.getChapter().getWorld());
    }

    @Override
    public String getCollectionTypeMsg() {
        return collectionTypeMsg;
    }

    @Override
    public String getCollectionInitDateMsg() {
        return collectionInitDateMsg;
    }

    @Override
    public String getCollectionSizeMsg() {
        return collectionSizeMsg;
    }

    @Override
    public String getInputNameMsg() {
        return inputNameMsg;
    }

    @Override
    public String getInputCoordinatesXMsg() {
        return inputCoordinatesXMsg;
    }

    @Override
    public String getInputCoordinatesYMsg() {
        return inputCoordinatesYMsg;
    }

    @Override
    public String getInputHealthMsg(){
        return inputHealthMsg;
    }

    @Override
    public String getInputHeartCountMsg(){
        return inputHeartCountMsg;
    }

    @Override
    public String getInputHeightMsg() {return inputHeightMsg;}

    @Override
    public String getInputWeaponTypeMsg(){
        return inputWeaponTypeMsg;
    }

    @Override
    public String getInputChapterNameMsg(){
        return inputChapterNameMsg;
    }

    @Override
    public String getInputChapterWorldMsg(){
        return inputChapterWorldMsg;
    }
}

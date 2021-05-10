package dataManager;

import spaceMarine.SpaceMarine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.TreeSet;


public class CSVSpaceMarineWriter implements DataWriter{
    private String fileName;

    public CSVSpaceMarineWriter(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void writeElements(TreeSet<SpaceMarine> collection){
    try {
        String string = makeFile(collection);
        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        fos.write(string.getBytes());
        System.out.println("все сохранилось заебись");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


        private String makeFile(TreeSet<SpaceMarine> collection) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("id,name,coordinatesX,coordinatesY,creationDate,health,heartCount,height,weaponType," +
                    "chapterName,chapterWorld");
            for (SpaceMarine spaceMarine : collection) {
                stringBuilder.append(String.format("\n%d,%s,%d,%d,%s,%d,%d,%d,%s,%s,%s",
                        spaceMarine.getId(),
                        spaceMarine.getName(),
                        spaceMarine.getCoordinates().getX(),
                        spaceMarine.getCoordinates().getY(),
                        spaceMarine.getCreationDate(),
                        spaceMarine.getHealth(),
                        spaceMarine.getHeartCount(),
                        spaceMarine.getHeight(),
                        spaceMarine.getWeaponType(),
                        spaceMarine.getChapter().getName(),
                        spaceMarine.getChapter().getWorld()));
            }
            return stringBuilder.toString();
        }
}

package input;

import exceptions.InvalidArgumentException;
import exceptions.ScriptException;
import inputManager.SpaceMarineReader;
import spaceMarine.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * класс реализующий интерфейс SpaceMarineReader
 */
public class ScriptSpaceMarineReader implements SpaceMarineReader {
    private BufferedReader reader;

    public ScriptSpaceMarineReader(BufferedReader reader){
        this.reader = reader;
    }

    @Override
    public RawSpaceMarine readSpaceMarine(){
        RawSpaceMarineBuilder spaceMarineBuilder = new RawSpaceMarineBuilderImpl();
        try {
            readFields(spaceMarineBuilder);
        } catch (IOException | InvalidArgumentException | NumberFormatException e){
            throw new ScriptException();
        }
        return spaceMarineBuilder.getRawSpaceMarine();
    }

    private void readFields(RawSpaceMarineBuilder spaceMarineBuilder) throws InvalidArgumentException, IOException{
        spaceMarineBuilder.setName(reader.readLine().trim());
        spaceMarineBuilder.setCoordinatesX(Integer.parseInt(reader.readLine().trim()));
        spaceMarineBuilder.setCoordinatesY(Long.parseLong(reader.readLine().trim()));
        spaceMarineBuilder.setHealth(Integer.parseInt(reader.readLine().trim()));
        spaceMarineBuilder.setHeartCount(Integer.parseInt(reader.readLine().trim()));
        spaceMarineBuilder.setHeight(Integer.parseInt(reader.readLine().trim()));
        spaceMarineBuilder.setWeaponType(Weapon.valueOf(reader.readLine().trim().toUpperCase()));
        spaceMarineBuilder.setChapterName(reader.readLine().trim());
        spaceMarineBuilder.setChapterWorld(reader.readLine().trim());
    }
}

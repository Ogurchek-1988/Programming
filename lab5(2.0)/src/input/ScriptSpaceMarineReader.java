package input;

import exceptions.InvalidArgumentException;
import exceptions.ScriptException;
import messeges.Messenger;
import spaceMarine.SpaceMarine;
import spaceMarine.SpaceMarineBuilderImpl;
import spaceMarine.SpaceMarineBuilder;
import spaceMarine.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;

/**
 * класс реализующий интерфейс SpaceMarineReader
 */
public class ScriptSpaceMarineReader implements SpaceMarineReader{
    private BufferedReader reader;
    private Messenger messenger;

    public ScriptSpaceMarineReader(BufferedReader reader, Messenger messenger){
        this.reader = reader;
        this.messenger = messenger;
    }

    @Override
    public SpaceMarine readSpaceMarine(){
        SpaceMarineBuilder spaceMarineBuilder = new SpaceMarineBuilderImpl(messenger);
        spaceMarineBuilder.setId();
        try {
            readFields(spaceMarineBuilder);
        } catch (IOException | InvalidArgumentException | NumberFormatException e){
            throw new ScriptException(messenger.getMesseng("script") + "\n");
        }
        return spaceMarineBuilder.getSpaceMarine();
    }

    @Override
    public SpaceMarine readSpaceMarine(long id, ZonedDateTime creationDate){
        SpaceMarineBuilder spaceMarineBuilder = new SpaceMarineBuilderImpl(messenger);
        try{
            spaceMarineBuilder.setId(id);
            spaceMarineBuilder.setCreationDate(creationDate);
            readFields(spaceMarineBuilder);
        } catch (IOException | InvalidArgumentException | NumberFormatException e){
            throw new ScriptException(messenger.getMesseng("script") + "\n");
        }
        return spaceMarineBuilder.getSpaceMarine();
    }

    private void readFields(SpaceMarineBuilder spaceMarineBuilder) throws InvalidArgumentException, IOException{
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

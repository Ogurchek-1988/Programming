package fileManager;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import messeges.Messenger;
import spaceMarine.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class CSVSpaceMarineReader implements DataReader{
    private String fileName;
    private  List<String[]> strLines;
    private String[] row;
    private Messenger messenger;

    public CSVSpaceMarineReader(String fileName, Messenger messenger){
        this.fileName = fileName;
        this.messenger = messenger;
    }


    @Override
    public Collection<? extends SpaceMarine> readElements() throws NoDataException, BrokenDataException, InvalidArgumentException {
        if (fileName == null){
            System.exit(1);
        }
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(fileName))){
            CsvParserSettings settings = new CsvParserSettings();
            settings.getFormat().setLineSeparator("\n");
            CsvParser parser = new CsvParser(settings);
            strLines = parser.parseAll(stream);
        }catch (IOException e) {
            e.printStackTrace();
            throw new NoDataException(e.getMessage());
        }catch (NullPointerException e){
            throw new BrokenDataException(e.getMessage());
        }
        Collection<SpaceMarine> spaceMarinesCollection = new TreeSet<>();
        String[] validFirstString = new String[]{"id", "name", "coordinatesX", "coordinatesY", "creationDate",
                "health", "heartCount", "height", "weaponType", "chapterName", "chapterWorld"};
        if (strLines.isEmpty() || !Arrays.equals(strLines.get(0), validFirstString)){
            throw new BrokenDataException(messenger.getMesseng("brokenData"));
        }
        strLines.remove(0);
        for (String[] s: strLines){
            spaceMarinesCollection.add(createSpaceMarin(s));
        }
        return spaceMarinesCollection;
    }
    private SpaceMarine createSpaceMarin(String[] row) throws InvalidArgumentException, BrokenDataException {
        try{
            SpaceMarineBuilder spaceMarineBuilder = new SpaceMarineBuilderImpl(messenger);
            spaceMarineBuilder.setId(Long.parseLong(row[0]));
            spaceMarineBuilder.setName(row[1]);
            spaceMarineBuilder.setCoordinatesX(Integer.parseInt(row[2]));
            spaceMarineBuilder.setCoordinatesY(Long.parseLong(row[3]));
            spaceMarineBuilder.setCreationDate(ZonedDateTime.parse(row[4]));
            spaceMarineBuilder.setHealth(Integer.parseInt(row[5]));
            spaceMarineBuilder.setHeartCount(Integer.parseInt(row[6]));
            spaceMarineBuilder.setHeight(Integer.parseInt(row[7]));
            spaceMarineBuilder.setWeaponType(Weapon.valueOf(row[8]));
            spaceMarineBuilder.setChapterName(row[9]);
            spaceMarineBuilder.setChapterWorld(row[10]);
            return spaceMarineBuilder.getSpaceMarine();
        } catch (IllegalArgumentException e){
            throw new InvalidArgumentException(e.getMessage());
        } catch (DateTimeParseException e){
            throw new BrokenDataException(messenger.getMesseng("brokenData"));
        }
    }
}

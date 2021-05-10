package dataManager;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import messages.Messenger;
import spaceMarine.RawSpaceMarineBuilder;
import spaceMarine.RawSpaceMarineBuilderImpl;
import spaceMarine.SpaceMarine;
import spaceMarine.Weapon;

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
    private final String fileName;
    private  List<String[]> strLines;
    private String[] row;
    private Messenger messenger;

    public CSVSpaceMarineReader(String fileName){
        this.fileName = fileName;
    }


    @Override
    public Collection<? extends SpaceMarine> readElements() throws NoDataException, BrokenDataException, InvalidArgumentException {
        if (fileName == null){
            System.out.println("oj govno faila net(((((");
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
    private SpaceMarine createSpaceMarin(String[] row) throws InvalidArgumentException{
        try{
            RawSpaceMarineBuilder spaceMarineBuilder = new RawSpaceMarineBuilderImpl();
            long id = Long.parseLong(row[0]);
            spaceMarineBuilder.setName(row[1]);
            spaceMarineBuilder.setCoordinatesX(Integer.parseInt(row[2]));
            spaceMarineBuilder.setCoordinatesY(Long.parseLong(row[3]));
            ZonedDateTime creationDate = ZonedDateTime.parse(row[4]);
            spaceMarineBuilder.setHealth(Integer.parseInt(row[5]));
            spaceMarineBuilder.setHeartCount(Integer.parseInt(row[6]));
            spaceMarineBuilder.setHeight(Integer.parseInt(row[7]));
            spaceMarineBuilder.setWeaponType(Weapon.valueOf(row[8]));
            spaceMarineBuilder.setChapterName(row[9]);
            spaceMarineBuilder.setChapterWorld(row[10]);
            return new SpaceMarine(id,creationDate,spaceMarineBuilder.getRawSpaceMarine());
        } catch (DateTimeParseException | IllegalArgumentException e){
            throw new InvalidArgumentException();
        }
    }
}

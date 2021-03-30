package fileManager;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import spaceMarine.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class CSVSpaceMarineReader implements DataReader{
    private String fileName;
    private  List<String[]> strLines;
    private String[] row;

    public CSVSpaceMarineReader(String fileName){
        this.fileName = fileName;
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
            throw new NoDataException("");
        }catch (NullPointerException e){
            throw new BrokenDataException("");
        }
        Collection<SpaceMarine> spaceMarinesCollection = new TreeSet<>();
        strLines.stream().forEach((String[] s) -> Arrays.stream(s).forEach(System.out::println));
        strLines.remove(0);
        for (String[] s: strLines){
            spaceMarinesCollection.add(createSpaceMarin(s));
        }
        return spaceMarinesCollection;
    }
    private SpaceMarine createSpaceMarin(String[] row) throws InvalidArgumentException{
        try{
            SpaceMarineBuilder spaceMarineBuilder = new SpaceMarineBuilderImpl();
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
            throw new InvalidArgumentException("");
        }
    }
}

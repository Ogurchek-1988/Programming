package fileManager;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import spaceMarine.SpaceMarine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

public class CSVSpaceMarineWriter implements DataWriter{
    private String fileName;
    private FileOutputStream outputStream;
    private OutputStreamWriter streamWriter;

    public CSVSpaceMarineWriter(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void writeElements(Collection<? extends SpaceMarine> collection) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName);
             OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream) ){
            CsvWriterSettings settings = new CsvWriterSettings();
            settings.getFormat().setLineSeparator("\n");
            CsvWriter writer = new CsvWriter(streamWriter, settings);

            //StringBuilder csv = new StringBuilder();
            for (SpaceMarine spaceMarine : collection) {
                //csv.append(spaceMarine.toString()).append('\n');
                writer.addValue(spaceMarine);
                writer.processValuesToRow();
                //writer.writeRow(spaceMarine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try{
            outputStream = new FileOutputStream(fileName);
            streamWriter = new OutputStreamWriter(outputStream);
        } catch (IOException e){
        }*/
    }
}

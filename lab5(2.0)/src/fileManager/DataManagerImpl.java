package fileManager;

import exceptions.BrokenDataException;
import exceptions.InvalidArgumentException;
import exceptions.NoDataException;
import messeges.Messenger;
import spaceMarine.SpaceMarine;

import java.util.Collection;

public class DataManagerImpl implements DataManager{
    private DataReader dataReader;
    private DataWriter dataWriter;

    public DataManagerImpl(DataReader dataReader, DataWriter dataWriter){
        this.dataReader = dataReader;
        this.dataWriter = dataWriter;
    }

    public DataManagerImpl(DataReader dataReader, DataWriter dataWriter, Messenger messenger) {
    }

    @Override
    public Collection<? extends SpaceMarine> readElements() throws InvalidArgumentException, NoDataException, BrokenDataException{
        return dataReader.readElements();
    }

    @Override
    public void writeElements(Collection<? extends SpaceMarine> collection){
        dataWriter.writeElements(collection);
    }
}

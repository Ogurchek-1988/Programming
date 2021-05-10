package input;

import exceptions.ScriptException;
import inputManager.CommandReader;
import messages.Messenger;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * реалицазия интерфейса CommandReader
 */
public class ScriptCommandReader implements CommandReader {
    private BufferedReader reader;

    public ScriptCommandReader(BufferedReader reader){
        this.reader = reader;
    }

    @Override
    public String readCommand(){
        try {
            String input = reader.readLine();
            return input.trim().toLowerCase();
        } catch (IOException e){
            throw new ScriptException();
        }
    }
}

package input;

import exceptions.InvalidArgumentException;
import inputManager.SpaceMarineReader;
import messages.Messenger;
import output.OutputManager;
import spaceMarine.RawSpaceMarine;

import spaceMarine.RawSpaceMarineBuilder;
import spaceMarine.RawSpaceMarineBuilderImpl;
import spaceMarine.Weapon;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * класс считывания объекта из консоли
 */
public class ConsoleSpaceMarineReader implements SpaceMarineReader {
    private final BufferedReader reader;
    private final OutputManager outputManager;
    private final Messenger messenger;

    public ConsoleSpaceMarineReader(BufferedReader reader, Messenger messenger, OutputManager outputManager){
        this.reader = reader;
        this.outputManager = outputManager;
        this.messenger = messenger;
    }

    @Override
    public RawSpaceMarine readSpaceMarine() throws IOException  {
        RawSpaceMarineBuilder spaceMarineBuilder = new RawSpaceMarineBuilderImpl();
        readFields(spaceMarineBuilder);
        return spaceMarineBuilder.getRawSpaceMarine();
    }

    private void readName(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputName") + ":");
        try{
            spaceMarineBuilder.setName(reader.readLine().trim());
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readName(spaceMarineBuilder);
        }
    }

    private void readCoordinatesX(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputCoordinatesX") + ":");
        try{
            spaceMarineBuilder.setCoordinatesX(Integer.parseInt(reader.readLine().trim()));
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readCoordinatesX(spaceMarineBuilder);
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getMesseng("noInteger") + "\n");
            readCoordinatesX(spaceMarineBuilder);
        }
    }

    private void readCoordinatesY(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputCoordinatesY") + ":");
        try{
            spaceMarineBuilder.setCoordinatesY(Long.parseLong(reader.readLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getMesseng("noLong") + "\n");
            readCoordinatesY(spaceMarineBuilder);
        }
    }

    private void readHealth(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputHealth") + ":");
        try {
            spaceMarineBuilder.setHealth(Integer.parseInt(reader.readLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getMesseng("noInteger") + "\n");
            readHealth(spaceMarineBuilder);
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readHealth(spaceMarineBuilder);
        }
    }

    private void readHeartCount(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputHeartCount") + ":");
        try{
            spaceMarineBuilder.setHeartCount(Integer.parseInt(reader.readLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getMesseng("noInteger") + "\n");
            readHeartCount(spaceMarineBuilder);
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readHeartCount(spaceMarineBuilder);
        }
    }

    private void readHeight(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputHeight") + ":");
        try{
            spaceMarineBuilder.setHeight(Integer.parseInt(reader.readLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getMesseng("noInteger") + "\n");
            readHeight(spaceMarineBuilder);
        }
    }

    private void readWeaponType(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputWeaponType") + ":");
        try{
            spaceMarineBuilder.setWeaponType(Weapon.valueOf(reader.readLine().trim().toUpperCase()));
        } catch (IllegalArgumentException e){
            outputManager.printErrorMsg(messenger.getMesseng("noEnum") + "\n");
            readWeaponType(spaceMarineBuilder);
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readWeaponType(spaceMarineBuilder);
        }
    }

    private void readChapterName(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputChapterName") + ":");
        try{
            spaceMarineBuilder.setChapterName(reader.readLine().trim());
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readChapterName(spaceMarineBuilder);
        }
    }

    private void readChapterWorld(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException{
        outputManager.printMsg(messenger.getMesseng("inputChapterWorld") + ":");
        try{
            spaceMarineBuilder.setChapterWorld(reader.readLine().trim());
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readChapterWorld(spaceMarineBuilder);
        }
    }


    private void readFields(RawSpaceMarineBuilder spaceMarineBuilder) throws IOException {
        readName(spaceMarineBuilder);
        readCoordinatesX(spaceMarineBuilder);
        readCoordinatesY(spaceMarineBuilder);
        readHealth(spaceMarineBuilder);
        readHeartCount(spaceMarineBuilder);
        readHeight(spaceMarineBuilder);
        readWeaponType(spaceMarineBuilder);
        readChapterName(spaceMarineBuilder);
        readChapterWorld(spaceMarineBuilder);
    }
}

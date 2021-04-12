package input;

import exceptions.InvalidArgumentException;
import messeges.Messenger;
import output.OutputManager;
import spaceMarine.SpaceMarine;
import spaceMarine.SpaceMarineBuilderImpl;
import spaceMarine.SpaceMarineBuilder;
import spaceMarine.Weapon;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class ConsoleSpaceMarineReader implements SpaceMarineReader{
    private Scanner scanner;
    private OutputManager outputManager;
    private Messenger messenger;

    public ConsoleSpaceMarineReader(Scanner scanner, OutputManager outputManager, Messenger messenger){
        this.scanner = scanner;
        this.outputManager = outputManager;
        this.messenger = messenger;
    }

    @Override
    public SpaceMarine readSpaceMarine(){
        SpaceMarineBuilder spaceMarineBuilder = new SpaceMarineBuilderImpl(messenger);
        spaceMarineBuilder.setId();
        readFileds(spaceMarineBuilder);
        return spaceMarineBuilder.getSpaceMarine();
    }

    @Override
    public SpaceMarine readSpaceMarine(long id, ZonedDateTime creationDate){
        SpaceMarineBuilder spaceMarineBuilder = new SpaceMarineBuilderImpl(messenger);
        try{
            spaceMarineBuilder.setId(id);
            spaceMarineBuilder.setCreationDate(creationDate);
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
        }
        readFileds(spaceMarineBuilder);
        return spaceMarineBuilder.getSpaceMarine();
    }

    private void readName(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("name") + ":");
        try{
            spaceMarineBuilder.setName(scanner.nextLine().trim());
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readName(spaceMarineBuilder);
        }
    }

    private void readCoordinatesX(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("coordinatesX") + ":");
        try{
            spaceMarineBuilder.setCoordinatesX(Integer.parseInt(scanner.nextLine().trim()));
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readCoordinatesX(spaceMarineBuilder);
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getExceptionMsg("noInteger") + "\n");
            readCoordinatesX(spaceMarineBuilder);
        }
    }

    private void readCoordinatesY(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("coordinatesY") + ":");
        try{
            spaceMarineBuilder.setCoordinatesY(Long.parseLong(scanner.nextLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getExceptionMsg("noLong") + "\n");
            readCoordinatesY(spaceMarineBuilder);
        }
    }

    private void readHealth(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("health") + ":");
        try {
            spaceMarineBuilder.setHealth(Integer.parseInt(scanner.nextLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getExceptionMsg("noInteger") + "\n");
            readHealth(spaceMarineBuilder);
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readHealth(spaceMarineBuilder);
        }
    }

    private void readHeartCount(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("heartCount") + ":");
        try{
            spaceMarineBuilder.setHeartCount(Integer.parseInt(scanner.nextLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getExceptionMsg("noInteger") + "\n");
            readHeartCount(spaceMarineBuilder);
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readHeartCount(spaceMarineBuilder);
        }
    }

    private void readHeight(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("height") + ":");
        try{
            spaceMarineBuilder.setHeight(Integer.parseInt(scanner.nextLine().trim()));
        } catch (NumberFormatException e){
            outputManager.printErrorMsg(messenger.getExceptionMsg("noInteger") + "\n");
            readHeight(spaceMarineBuilder);
        }
    }

    private void readWeaponType(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("weaponType") + ":");
        try{
            spaceMarineBuilder.setWeaponType(Weapon.valueOf(scanner.nextLine().trim().toUpperCase()));
        } catch (IllegalArgumentException e){
            outputManager.printErrorMsg(messenger.getExceptionMsg("noEnum") + "\n");
            readWeaponType(spaceMarineBuilder);
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readWeaponType(spaceMarineBuilder);
        }
    }

    private void readChapterName(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("chapterName") + ":");
        try{
            spaceMarineBuilder.setChapterName(scanner.nextLine().trim());
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readChapterName(spaceMarineBuilder);
        }
    }

    private void readChapterWorld(SpaceMarineBuilder spaceMarineBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("chapterWorld") + ":");
        try{
            spaceMarineBuilder.setChapterWorld(scanner.nextLine().trim());
        } catch (InvalidArgumentException e){
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readChapterWorld(spaceMarineBuilder);
        }
    }


    private void readFileds(SpaceMarineBuilder spaceMarineBuilder){
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

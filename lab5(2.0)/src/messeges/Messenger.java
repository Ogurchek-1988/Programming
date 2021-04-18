/*
package messeges;

import exceptions.NoSuchCommandException;
import spaceMarine.SpaceMarine;
*/
/**
 * Интерфейс мессенджер
 *//*

public interface Messenger {

    String getExceptionMsg(String msgName);

    String getCommandDescription(String commandName) throws NoSuchCommandException;

    String getCollectionTypeMsg();

    String getCollectionInitDateMsg();

    String getCollectionSizeMsg();

    String getSpaceMarineString(SpaceMarine spaceMarine);

    String getFieldInputMsg(String fieldName);

    String getStartMsg();

    String getFinishMsg();
}
*/
package messeges;

import exceptions.NoSuchCommandException;
import spaceMarine.SpaceMarine;

public interface Messenger {
    String getMesseng(String msgName);

    String getSpaceMarineString(SpaceMarine spaceMarine);

    String getFieldInputMsg(String fieldName) throws NoSuchCommandException;

    String getCommandDescription(String commandName) throws NoSuchCommandException;
}


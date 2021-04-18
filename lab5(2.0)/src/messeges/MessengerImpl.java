/*

package messeges;

import exceptions.NoMsgException;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchFieldException;
import spaceMarine.SpaceMarine;

*/
/**
 * класс, реализующий интерфейс мессенджер
 *//*


public class MessengerImpl implements Messenger{
        private CommandMessages commandMessages;
        private ExceptionMessages exceptionMessages;
        private CollectionMessages collectionMessages;
        private String startMsg;
        private String finishMsg;

        public MessengerImpl(CommandMessages commandMessages, ExceptionMessages exceptionMessages, CollectionMessages collectionMessages){
            this.commandMessages = commandMessages;
            this.exceptionMessages = exceptionMessages;
            this.collectionMessages = collectionMessages;
            startMsg = "Program started";
            finishMsg = "Program finished";
        }

        @Override
        public String getStartMsg() {
            return startMsg;
        }

        @Override
        public String getFinishMsg() {
            return finishMsg;
        }

        @Override
        public String getExceptionMsg(String msgName){
            switch (msgName){
                case "invalidId":
                    return exceptionMessages.getInvalidIdMsg();

                case "notUniqueId":
                    return exceptionMessages.getNotUniqueIdMsg();

                case "noIdLeft":
                    return exceptionMessages.getNoIdLeftMsg();

                case "invalidName":
                    return exceptionMessages.getInvalidNameMsg();

                case "invalidCoordinates":
                    return exceptionMessages.getInvalidCoordinatesMsg();

                case "invalidCoordinatesX":
                    return exceptionMessages.getInvalidCoordinatesXMsg();

                case "invalidCreationDate":
                    return exceptionMessages.getInvalidCreationDateMsg();

                case "invalidHealth":
                    return exceptionMessages.getInvalidHealthMsg();

                case "invalidHeartCount":
                    return exceptionMessages.getInvalidHeartCountMsg();

                case "invalidWeaponType":
                    return exceptionMessages.getInvalidWeaponTypeMsg();

                case "invalidChapterName":
                    return exceptionMessages.getInvalidChapterNameMsg();

                case "invalidChapterWorld":
                    return exceptionMessages.getInvalidChapterWorldMsg();

                case "noInteger":
                    return exceptionMessages.getNoIntegerMsg();

                case "noLong":
                    return exceptionMessages.getNoLongMsg();

                case "noDate":
                    return exceptionMessages.getNoDateMsg();

                case "noEnum":
                    return exceptionMessages.getNoEnumMsg();

                case "noArg":
                    return exceptionMessages.getNoArgMsg();

                case "brokenData":
                    return exceptionMessages.getBrokenDataMsg();

                case "noEnvVar":
                    return exceptionMessages.getNoEnvVarMsg();

                case "noData":
                    return exceptionMessages.getNoDataMsg();

                case "wrongFieldType":
                    return exceptionMessages.getWrongFieldTypeMsg();

                case "noSuchCommand":
                    return exceptionMessages.getNoSuchCommandMsg();

                case "noSuchId":
                    return exceptionMessages.getNoSuchIdMsg();

                case "noSuchField":
                    return exceptionMessages.getNoSuchFieldMsg();

                case "noSuchElement":
                    return exceptionMessages.getNoSuchElementMsg();

                case "script":
                    return exceptionMessages.getScriptMsg();

                case "noFile":
                    return exceptionMessages.getNoFileMsg();

                case "scriptRecursion":
                    return exceptionMessages.getScriptRecursionMsg();

                default:
                    throw new NoMsgException(exceptionMessages.getNoMsgMsg());
            }
        }

        @Override
        public String getCommandDescription(String commandName) throws NoSuchCommandException {
            switch (commandName){
                case "add":
                    return commandMessages.getAddDescription();

                case "add_if_min":
                    return commandMessages.getAddIfMinDescription();

                case "clear":
                    return commandMessages.getClearDescription();

                case "execute_script":
                    return commandMessages.getExecuteScriptDescription();

                case "exit":
                    return commandMessages.getExitDescription();

                case "filter_contains_name":
                    return commandMessages.getFilterContainsNameDescription();

                case "help":
                    return commandMessages.getHelpDescription();

                case "remove_greater":
                    return commandMessages.getRemoveGreaterDescription();

                case "info":
                    return commandMessages.getInfoDescription();

                case "remove_lower":
                    return commandMessages.getRemoveLowerDescription();

                case "sum_of_height":
                    return commandMessages.getSumOfHeightDescription();

                case "remove_by_id":
                    return commandMessages.getRemoveByIdDescription();

                case "save":
                    return commandMessages.getSaveDescription();

                case "show":
                    return commandMessages.getShowDescription();

                case "max_by_health":
                    return commandMessages.getMaxByHealthDescription();

                case "update":
                    return commandMessages.getUpdateDescription();

                default:
                    throw new NoSuchCommandException(exceptionMessages.getNoSuchCommandMsg());
            }
        }

        @Override
        public String getFieldInputMsg(String fieldName) {
            switch(fieldName){
                case "name":
                    return collectionMessages.getInputNameMsg();

                case "coordinatesX":
                    return collectionMessages.getInputCoordinatesXMsg();

                case "coordinatesY":
                    return collectionMessages.getInputCoordinatesYMsg();

                case "health":
                    return collectionMessages.getInputHealthMsg();

                case "heartCount":
                    return collectionMessages.getInputHeartCountMsg();

                case "height":
                    return collectionMessages.getInputHeightMsg();

                case "weaponType":
                    return collectionMessages.getInputWeaponTypeMsg();

                case "chapterName":
                    return collectionMessages.getInputChapterNameMsg();

                case "chapterWorld":
                    return collectionMessages.getInputChapterWorldMsg();

                default:
                    throw new NoSuchFieldException(exceptionMessages.getNoSuchFieldMsg());
            }
        }

        @Override
        public String getCollectionTypeMsg() {
            return collectionMessages.getCollectionTypeMsg();
        }

        @Override
        public String getCollectionInitDateMsg() {
            return collectionMessages.getCollectionInitDateMsg();
        }

        @Override
        public String getCollectionSizeMsg() {
            return collectionMessages.getCollectionSizeMsg();
        }

        @Override
        public String getSpaceMarineString(SpaceMarine spaceMarine) {
            return collectionMessages.getSpaceMarin4    eString(spaceMarine);
        }
}
*/

package messeges;

import exceptions.NoSuchCommandException;
import spaceMarine.SpaceMarine;

import java.util.HashMap;

public class MessengerImpl implements Messenger{
    private final HashMap<String, String> messages;
    private Messenger messenger;
    public MessengerImpl(){
        messages = new HashMap<>();
        messages.put("help", " вывести справку по доступным командам");
        messages.put("add"," добавить новый элемент в коллекцию");
        messages.put("add_if_min"," добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        messages.put("clear"," очистить коллекцию");
        messages.put("execute_script"," считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        messages.put("exit"," завершить программу (с сохранением в файл)");
        messages.put("filter_contains_name"," вывести элементы, значение поля name которых содержит заданную подстроку");
        messages.put("info"," вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        messages.put("remove_by_id"," удалить элемент из коллекции по его id");
        messages.put("show"," вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        messages.put("update"," обновить значение элемента коллекции, id которого равен заданному");
        messages.put("remove_greater"," удалить из коллекции все элементы, превышающие заданный");
        messages.put("remove_lower"," удалить из коллекции все элементы, меньшие, чем заданный");
        messages.put("sum_of_height"," вывести сумму значений поля height для всех элементов коллекции");
        messages.put("max_by_health"," вывести любой объект из коллекции, значение поля health которого является максимальным");
        messages.put("invalidId"," invalid id value, must be more than 0");
        messages.put("notUniqueId"," not uniq id");
        messages.put("noIdLeft"," no id left");
        messages.put("invalidName"," invalid name value, must be not null");
        messages.put("invalidCoordinates"," invalid coordinates value, must be not null");
        messages.put("invalidCoordinatesX"," invalid coordinates.x value, must be more than -941 and not null");
        messages.put("invalidCreationDate"," invalid creationDate value, must be not null");
        messages.put("invalidHealth"," invalid height value, must be more than 0");
        messages.put("invalidHeartCount"," invalid heartCount value, must be more than 0, must no be more than 3 and not null");
        messages.put("invalidWeaponType"," invalid weaponType value, must be not null");
        messages.put("invalidChapterName"," invalid chapterName value, must be not null");
        messages.put("invalidChapterWorld"," invalid chapterWorld value, must be not null");
        messages.put("noInteger"," value must be integer number");
        messages.put("noLong"," value must be long number");
        messages.put("noDate"," date must be in the specified format");
        messages.put("noEnum"," value must be selected from the suggested options");
        messages.put("noArg"," this command needs 1 argument");
        messages.put("noMsg"," this message does not exist");
        messages.put("noEnvVar"," environmental variable does not exist");
        messages.put("brokenData"," file is broken, program starts with empty collection");
        messages.put("noData"," file does not exist");
        messages.put("wrongFieldType"," wrong field type");
        messages.put("noSuchCommand"," no such command");
        messages.put("noSuchId"," an element with this id does not exist");
        messages.put("noSuchField"," this field does not exist in class Person");
        messages.put("noSuchElement"," end of input");
        messages.put("script"," script error, script execution stopped");
        messages.put("noFile"," this file does not exist");
        messages.put("scriptRecursion"," script calls recursion, script execution stopped");
        messages.put("collectionType"," Collection type");
        messages.put("collectionInitDate"," Initialization date");
        messages.put("collectionSize"," Number of elements");
        messages.put("inputName","Name");
        messages.put("inputCoordinatesX","coordinates.x");
        messages.put("inputCoordinatesY","coordinates.y");
        messages.put("inputHealth","health");
        messages.put("inputHeartCount","heart count [1;3]");
        messages.put("inputHeight","height");
        messages.put("inputWeaponType","weaponType (BOLTGUN, HEAVY_BOLTGUN, PLASMA_GUN, MULTI_MELTA)");
        messages.put("inputChapterName","chapter.Name");
        messages.put("inputChapterWorld","chapter.World");
        messages.put("start","Program started");
        messages.put("finish","Program finished");
    }

    @Override
    public String getMesseng(String msgName){
        return messages.get(msgName);
    }

    @Override
    public String getSpaceMarineString(SpaceMarine spaceMarine) {
        return messenger.getSpaceMarineString(spaceMarine);
    }

    @Override
    public String getFieldInputMsg(String fieldName) throws NoSuchCommandException {
        if (messages.get(fieldName) != null){
        return messages.get(fieldName);} else throw new NoSuchCommandException(messenger.getMesseng("noSuchCommand"));

    }

    public String getCommandDescription(String commandName) throws NoSuchCommandException {
        if (messages.get(commandName) != null){
            return messages.get(commandName);
        } else throw new NoSuchCommandException(messenger.getMesseng("noSuchCommand"));
    }


}




/**
 * класс, реализующий интерфейс мессенджер
 */
package messages;

import java.util.HashMap;

public class    MessengerImpl implements Messenger{
    private final HashMap<String, String> messages;

    public MessengerImpl(){
        messages = new HashMap<>();
        messages.put("helpDescription", " help: вывести справку по доступным командам");
        messages.put("addDescription"," add: добавить новый элемент в коллекцию");
        messages.put("add_if_minDescription"," add_if_min: добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        messages.put("clearDescription"," clear: очистить коллекцию");
        messages.put("execute_scriptDescription"," execute_script: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        messages.put("exitDescription"," exit: завершить программу (с сохранением в файл)");
        messages.put("filter_contains_nameDescription"," filter_contains_name: вывести элементы, значение поля name которых содержит заданную подстроку");
        messages.put("infoDescription"," info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        messages.put("remove_by_idDescription"," remove_by_id: удалить элемент из коллекции по его id");
        messages.put("showDescription"," show: вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        messages.put("updateDescription"," update: обновить значение элемента коллекции, id которого равен заданному");
        messages.put("remove_greaterDescription"," remove_grater: удалить из коллекции все элементы, превышающие заданный");
        messages.put("remove_lowerDescription"," remove_lower: удалить из коллекции все элементы, меньшие, чем заданный");
        messages.put("sum_of_heightDescription"," sum_of_height: вывести сумму значений поля height для всех элементов коллекции");
        messages.put("max_by_healthDescription"," max_by_health: вывести любой объект из коллекции, значение поля health которого является максимальным");
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
        messages.put("start","program started");
        messages.put("finish","Program finished");
        messages.put("exitOutput", "exit application");
        messages.put("addOutput", "element added to the collection");
        messages.put("showOutput","all elements in the collection");
        messages.put("helpOutput","help for commands");
        messages.put("notAddOutput","element didn't add to the collection");
        messages.put("clearOutput","collection cleared");
        messages.put("filterContainsNameOutput","elements, contains name in the collection");
        messages.put("historyOutput","command history");
        messages.put("maxByEyeColorOutput","largest element by eyeColor");
        messages.put("printFieldDescendingEyeColorOutput","eye colors in descending order");
        messages.put("removeOutput","element removed from collection");
        messages.put("notRemoveOutput","element didn't remove from the collection because element with this id does not exist");
        messages.put("updateOutput","element updated successfully");
        messages.put("notUpdateOutput","element was not updated because element with this id does not exist");
        messages.put("saveOutput", "collection is saved to a file");
        messages.put("scriptOutput", "script is executed");
        messages.put("noConnection", "failed to establish a connection to the server, please try again");
    }

    @Override
    public String getMesseng(String msgName){
        return messages.get(msgName);
    }

}




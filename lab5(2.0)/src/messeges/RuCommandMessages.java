package messeges;

public class RuCommandMessages implements CommandMessages{
    private final String addDescription;
    private final String addIfMinDescription;
    private final String clearDescription;
    private final String executeScriptDescription;
    private final String exitDescription;
    private final String filterContainsNameDescription;
    private final String helpDescription;
    private final String infoDescription;
    private final String removeByIdDescription;
    private final String saveDescription;
    private final String showDescription;
    private final String updateDescription;
    private final String removeGreater;
    private final String removeLower;
    private final String sumOfHeight;
    private final String maxByHealth;

    public RuCommandMessages(){
        addDescription = "add {element} : добавить новый элемент в коллекцию";
        addIfMinDescription = "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
        clearDescription = "clear : очистить коллекцию";
        executeScriptDescription = "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
        exitDescription = "завершить программу (без сохранения в файл)";
        filterContainsNameDescription = "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку";
        helpDescription = "help : вывести справку по доступным командам";
        infoDescription = "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
        removeByIdDescription = "remove_by_id id : удалить элемент из коллекции по его id";
        saveDescription = "save : сохранить коллекцию в файл";
        showDescription = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
        updateDescription = "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
        removeGreater = "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
        removeLower = "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
        sumOfHeight = "sum_of_height : вывести сумму значений поля height для всех элементов коллекции";
        maxByHealth = "max_by_health : вывести любой объект из коллекции, значение поля health которого является максимальным";
    }

    @Override
    public String getAddDescription(){
        return addDescription;
    }

    @Override
    public String getAddIfMinDescription(){
        return addIfMinDescription;
    }

    @Override
    public String getClearDescription(){
        return clearDescription;
    }

    @Override
    public String getExecuteScriptDescription(){
        return executeScriptDescription;
    }

    @Override
    public String getExitDescription(){
        return exitDescription;
    }

    @Override
    public String getFilterContainsNameDescription(){
        return filterContainsNameDescription;
    }

    @Override
    public String getHelpDescription(){
        return helpDescription;
    }

    @Override
    public String getInfoDescription(){
        return infoDescription;
    }

    @Override
    public String getRemoveByIdDescription(){
        return removeByIdDescription;
    }

    @Override
    public String getSaveDescription(){
        return saveDescription;
    }

    @Override
    public String getShowDescription(){
        return showDescription;
    }

    @Override
    public String getUpdateDescription(){
        return updateDescription;
    }

    @Override
    public String getRemoveGreaterDescription(){
        return removeGreater;
    }

    @Override
    public String getRemoveLowerDescription(){
        return removeLower;
    }

    @Override
    public String getSumOfHeightDescription(){
        return sumOfHeight;
    }

    @Override
    public String getMaxByHealthDescription(){
        return maxByHealth;
    }
}

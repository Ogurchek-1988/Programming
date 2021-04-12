package messeges;

public class EngExceptionMessages implements ExceptionMessages{
    private final String invalidIdMsg;
    private final String notUniqueIdMsg;
    private final String noIdLeftMsg;
    private final String invalidNameMsg;
    private final String invalidCoordinatesMsg;
    private final String invalidCoordinatesXMsg;
    private final String invalidCreationDateMsg;
    private final String invalidHealthMsg;
    private final String invalidHeartCountMsg;
    private final String invalidWeaponTypeMsg;
    private final String invalidChapterNameMsg;
    private final String invalidChapterWorldMsg;
    private final String noIntegerMsg;
    private final String noLongMsg;
    private final String noDateMsg;
    private final String noEnumMsg;
    private final String noArgMsg;
    private final String noMsgMsg;
    private final String noEnvVarMsg;
    private final String brokenDataMsg;
    private final String noDataMsg;
    private final String wrongFieldTypeMsg;
    private final String noSuchCommandMsg;
    private final String noSuchIdMsg;
    private final String noSuchFieldMsg;
    private final String noSuchElementMsg;
    private final String scriptMsg;
    private final String noFileMsg;
    private final String scriptRecursionMsg;

    public EngExceptionMessages(){
        invalidIdMsg = " invalid id value, must be more than 0";
        notUniqueIdMsg = " not uniq id";
        noIdLeftMsg = " no id left";
        invalidNameMsg = " invalid name value, must be not null";
        invalidCoordinatesMsg = " invalid coordinates value, must be not null";
        invalidCoordinatesXMsg = " invalid coordinates.x value, must be more than -941 and not null";
        invalidCreationDateMsg = " invalid creationDate value, must be not null";
        invalidHealthMsg = " invalid height value, must be more than 0";
        invalidHeartCountMsg = " invalid heartCount value, must be more than 0, must no be more than 3 and not null";
        invalidWeaponTypeMsg = " invalid weaponType value, must be not null";
        invalidChapterNameMsg = " invalid chapterName value, must be not null";
        invalidChapterWorldMsg = " invalid chapterWorld value, must be not null";
        noIntegerMsg = " value must be integer number";
        noLongMsg = " value must be long number";
        noDateMsg = " date must be in the specified format";
        noEnumMsg = " value must be selected from the suggested options";
        noArgMsg = " this command needs 1 argument";
        noMsgMsg = " this message does not exist";
        noEnvVarMsg = " environmental variable does not exist";
        brokenDataMsg = " file is broken, program starts with empty collection";
        noDataMsg = " file does not exist";
        wrongFieldTypeMsg = " wrong field type";
        noSuchCommandMsg = " no such command";
        noSuchIdMsg = " An element with this id does not exist";
        noSuchFieldMsg = " This field does not exist in class Person";
        noSuchElementMsg = " end of input";
        scriptMsg = " script error, script execution stopped";
        noFileMsg = " this file does not exist";
        scriptRecursionMsg = " script calls recursion, script execution stopped";
    }
    @Override
    public String getInvalidIdMsg(){
        return invalidIdMsg;
    }

    @Override
    public String getNotUniqueIdMsg(){
        return notUniqueIdMsg;
    }

    @Override
    public String getNoIdLeftMsg(){
        return noIdLeftMsg;
    }

    @Override
    public String getInvalidNameMsg(){
        return invalidNameMsg;
    }

    @Override
    public String getInvalidCoordinatesMsg(){
        return invalidCoordinatesMsg;
    }

    @Override
    public String getInvalidCoordinatesXMsg(){
        return invalidCoordinatesXMsg;
    }

    @Override
    public String getInvalidCreationDateMsg(){
        return invalidCreationDateMsg;
    }

    @Override
    public String getInvalidHealthMsg(){
        return invalidHealthMsg;
    }

    @Override
    public String getInvalidHeartCountMsg(){
        return invalidHeartCountMsg;
    }

    @Override
    public String getInvalidWeaponTypeMsg(){
        return invalidWeaponTypeMsg;
    }

    @Override
    public String getInvalidChapterNameMsg(){
        return invalidChapterNameMsg;
    }

    @Override
    public String getInvalidChapterWorldMsg(){
        return invalidChapterWorldMsg;
    }

    @Override
    public String getNoIntegerMsg(){
        return noIntegerMsg;
    }

    @Override
    public String getNoLongMsg(){
        return noLongMsg;
    }

    @Override
    public String getNoDateMsg(){
        return noDateMsg;
    }

    @Override
    public String getNoEnumMsg(){
        return noEnumMsg;
    }

    @Override
    public String getNoArgMsg(){
        return noArgMsg;
    }

    @Override
    public String getNoMsgMsg(){
        return noMsgMsg;
    }

    @Override
    public String getNoEnvVarMsg(){
        return noEnvVarMsg;
    }

    @Override
    public String getBrokenDataMsg(){
        return brokenDataMsg;
    }

    @Override
    public String getNoDataMsg(){
        return noDataMsg;
    }

    @Override
    public String getWrongFieldTypeMsg(){
        return wrongFieldTypeMsg;
    }

    @Override
    public String getNoSuchCommandMsg(){
        return noSuchCommandMsg;
    }

    @Override
    public String getNoSuchIdMsg(){
        return noSuchIdMsg;
    }

    @Override
    public String getNoSuchFieldMsg(){
        return noSuchFieldMsg;
    }

    @Override
    public String getNoSuchElementMsg(){
        return noSuchElementMsg;
    }

    @Override
    public String getScriptMsg(){
        return scriptMsg;
    }

    @Override
    public String getNoFileMsg(){
        return noFileMsg;
    }

    @Override
    public String getScriptRecursionMsg(){
        return scriptRecursionMsg;
    }
}

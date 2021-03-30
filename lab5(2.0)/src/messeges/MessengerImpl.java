package messeges;

import exceptions.NoMsgException;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchFieldException;
import spaceMarine.SpaceMarine;

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
            return collectionMessages.getSpaceMarineString(spaceMarine);
        }
}



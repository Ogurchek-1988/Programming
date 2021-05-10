package commands;

import command.RequiringArg;
import exceptions.InvalidArgumentTypeException;
import exceptions.NeedObjectException;
import exceptions.NoArgException;
import networkMessages.RequestType;
import spaceMarine.RawSpaceMarine;

public interface ServerCommandInvoker {

    void invokeCommand(ServerCommand command);

    void setLongArgToCommand(RequiringArg<Long> command) throws InvalidArgumentTypeException, NoArgException;

    void setStringArgToCommand(RequiringArg<String> command) throws NoArgException;

    void setObjectToCommand(RequiringObject command) throws NeedObjectException;

    void setArg(String arg);

    void setObject(RawSpaceMarine spaceMarine);

    void setType(RequestType type);

    String getCommandOutput();
}

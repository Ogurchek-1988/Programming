package commands;

import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;

public interface CommandInvoker {

    void invokeCommand(Command command);

    void setLongArg(RequiringArg<Long> command) throws InvalidArgumentTypeException, NoArgException;

    void setStringArg(RequiringArg<String> command) throws NoArgException;

    void setArg(String arg);
}

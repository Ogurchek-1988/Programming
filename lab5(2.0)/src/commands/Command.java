package commands;

import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;

public interface Command {

    void execute();

    default void acceptInvoker(CommandInvoker commandInvoker) throws NoArgException, InvalidArgumentTypeException {
        commandInvoker.invokeCommand(this);
    }
}

package commands;

import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import messeges.Messenger;

public class CommandInvokerImpl implements CommandInvoker{
    private String arg;
    private Messenger messenger;

    public CommandInvokerImpl(Messenger messenger){
        this.messenger = messenger;
    }

    @Override
    public void invokeCommand(Command command){
        command.execute();
    }

    @Override
    public void setLongArg(RequiringArg<Long> command) throws InvalidArgumentTypeException, NoArgException{
        if (!arg.equals("")){
            try {
                command.setArg(Long.parseLong(arg));
            } catch (NumberFormatException e){
                throw new InvalidArgumentTypeException(messenger.getMesseng("noLong"));
            }
        } else{
            throw new NoArgException(messenger.getMesseng("noArg"));
        }
    }

    @Override
    public void setStringArg(RequiringArg<String> command) throws NoArgException{
        if (!arg.equals("")){
            command.setArg(arg);
        } else{
            throw new NoArgException(messenger.getMesseng("noArg"));
        }
    }

    @Override
    public void setArg(String arg){
        this.arg = arg;
    }
}

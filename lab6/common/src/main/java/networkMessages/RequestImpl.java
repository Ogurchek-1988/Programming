package networkMessages;

import spaceMarine.RawSpaceMarine;
import spaceMarine.SpaceMarine;

import java.io.Serializable;
import java.util.Objects;

public class RequestImpl implements Request, Serializable {
    private static final long serialVersionUID = 8785774135702639006L;
    private final RequestType type;
    private final String command;
    private final String arg;
    private final RawSpaceMarine spaceMarine;

    public RequestImpl(RequestType type, String command, String arg, RawSpaceMarine spaceMarine){
        this.type = type;
        this.command = command;
        this.arg = arg;
        this.spaceMarine = spaceMarine;
    }

    @Override
    public RequestType getType(){
        return type;
    }

    @Override
    public String getCommand(){
        return command;
    }

    @Override
    public String getArg(){
        return arg;
    }

    @Override
    public RawSpaceMarine getObject(){
        return spaceMarine;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        RequestImpl request = (RequestImpl) o;
        return type == request.type && command.equals(request.command) && Objects.equals(arg,request.arg) && Objects.equals(spaceMarine, request.spaceMarine);
    }

    @Override
    public int hashCode(){
        return Objects.hash(type, command, arg, spaceMarine);
    }

    @Override
    public String toString(){
        return String.format("RequestImpl(type=%s, command=%s, aeg=%s, spaceMarine=%s)", type, command, arg, spaceMarine);

    }

}
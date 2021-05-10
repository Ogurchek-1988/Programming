package networkMessages;

import spaceMarine.RawSpaceMarine;

public interface Request {
    RequestType getType();
    String getCommand();
    String getArg();
    RawSpaceMarine getObject();
}

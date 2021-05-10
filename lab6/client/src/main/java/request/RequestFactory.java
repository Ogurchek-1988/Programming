package request;

import networkMessages.Request;
import spaceMarine.RawSpaceMarine;

public interface RequestFactory {
    Request createArgObjectRequest(String command, String arg, RawSpaceMarine spaceMarine);
    Request createObjectRequest(String command, RawSpaceMarine spaceMarine);
    Request createArgRequest(String command, String arg);
    Request createSimpleRequest(String command);
}

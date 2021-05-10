package commands;

import exceptions.NoSuchCommandException;
import networkMessages.RequestType;
import spaceMarine.RawSpaceMarine;

import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;

/**
 * Iнтерфейс менеджера команд
 */
public interface ServerCommandManager {
    void executeClientCommand(RequestType type, String command, String arg, RawSpaceMarine spaceMarine, SocketAddress  address, DatagramChannel channel);
    void executeServerCommand(String command);
}

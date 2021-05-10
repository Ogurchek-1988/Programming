package commands;

import collectionManager.CollectionManager;
import exceptions.NoSuchCommandException;
import exceptions.*;
import messages.Messenger;
import networkMessages.RequestType;
import responses.ResponsesFactory;
import responses.ResponsesSender;
import responses.ServerResponsesFactory;
import responses.ServerResponsesSender;
import server.Application;
import spaceMarine.RawSpaceMarine;

import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.HashMap;
import java.util.Map;

public class ServerCommandManagerImpl implements ServerCommandManager {
    private Map<String, ServerCommand> clientCommandMap;
    private Map<String, ServerCommand> serverCommandMap;
    private Messenger messenger;
    private final ServerCommandInvoker commandInvoker;
    private final ServerCommandInvoker commandInvokerForServerCommands;

    public ServerCommandManagerImpl(CollectionManager collectionManager, Application app, Messenger messenger){
        this.messenger = messenger;
        clientCommandMap = new HashMap<>();
        serverCommandMap = new HashMap<>();
        commandInvoker = new ServerCommandInvokerImpl();
        commandInvokerForServerCommands = new ServerCommandInvokerImpl();
        clientCommandMap.put("help", new HelpCommand(clientCommandMap.keySet(), messenger));
        clientCommandMap.put("info", new InfoCommand(collectionManager, messenger));
        clientCommandMap.put("show", new ShowCommand(collectionManager,messenger));
        clientCommandMap.put("add", new AddCommand(collectionManager,messenger));
        clientCommandMap.put("update", new UpdateCommand(collectionManager,messenger));
        clientCommandMap.put("remove_by_id", new RemoveByIdCommand(collectionManager,messenger));
        clientCommandMap.put("clear", new ClearCommand(collectionManager, messenger));
        clientCommandMap.put("add_if_min", new AddIfMinCommand(collectionManager,messenger));
        clientCommandMap.put("remove_greater", new RemoveGreaterCommand(collectionManager,messenger));
        clientCommandMap.put("remove_lower", new RemoveLowerCommand(collectionManager, messenger));
        clientCommandMap.put("sum_of_height", new SumOfHeightCommand(collectionManager,messenger));
        clientCommandMap.put("max_by_health", new MaxByHealthCommand(collectionManager,messenger));
        clientCommandMap.put("filter_contains_name", new FilterContainsNameCommand(collectionManager,messenger));

        serverCommandMap.put("save", new SaveCommand(collectionManager,messenger));
        serverCommandMap.put("exit", new ExitCommand(collectionManager,app,messenger));
    }

    @Override
    public void executeClientCommand(RequestType type, String command, String arg, RawSpaceMarine spaceMarine,
                                     SocketAddress address, DatagramChannel channel){
        ResponsesFactory responsesFactory = new ServerResponsesFactory();
        ResponsesSender responsesSender = new ServerResponsesSender(channel, address);
        if (clientCommandMap.containsKey(command)){
            commandInvoker.setType(type);
            commandInvoker.setArg(arg);
            commandInvoker.setObject(spaceMarine);
            try{
                clientCommandMap.get(command).acceptInvoker(commandInvoker);
                responsesSender.sendResponse(responsesFactory.createDefaultResponse(commandInvoker.getCommandOutput()));
            }catch (NoArgException e){
                responsesSender.sendResponse(responsesFactory.createErrorResponse("noArg"));
            } catch (InvalidArgumentTypeException e){
                responsesSender.sendResponse(responsesFactory.createErrorResponse("invalidArgumentType"));
            } catch (NeedObjectException e){
                responsesSender.sendResponse(responsesFactory.createNeedObjectResponse());
            }
        } else {
            responsesSender.sendResponse(responsesFactory.createErrorResponse("noSuchCommand"));
        }
    }

    @Override
    public void executeServerCommand(String command) {
        if (serverCommandMap.containsKey(command)){
            try{
                serverCommandMap.get(command).acceptInvoker(commandInvokerForServerCommands);
            } catch (NoArgException | InvalidArgumentTypeException | NeedObjectException e){

            }
        }
    }
}

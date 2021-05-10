package server;

import collectionManager.CollectionManager;
import collectionManager.SpaceMarineCollectionManager;
import commands.*;
import connection.ServerConnectionManager;
import connection.ServerConnectionManagerImpl;
import dataManager.*;
import exceptions.NoEnvVarException;
import messages.Messenger;
import messages.MessengerImpl;

import java.io.IOException;
import java.nio.channels.DatagramChannel;

public class ServerApplication implements Application {
    private final int port;
    private ServerConnectionManager connectionManager;
    private CommandsReader serverCommandsReader;
    private CommandsReader clientCommandsReader;

    public ServerApplication(int port){
        this.port = port;
    }

    @Override
    public void start(String fileName) {
        Messenger messenger = new MessengerImpl();
        DataReader dataReader = new CSVSpaceMarineReader(fileName);
        DataWriter dataWriter = new CSVSpaceMarineWriter(fileName);
        DataManager dataManager = new DataManagerImpl(dataReader,dataWriter);
        CollectionManager collectionManager = new SpaceMarineCollectionManager(dataManager);
        connectionManager = new ServerConnectionManagerImpl();
        ServerCommandManager commandManager = new ServerCommandManagerImpl(collectionManager,this,messenger);
        serverCommandsReader = new ServerCommandsReader(commandManager,messenger);
        try{
            DatagramChannel channel = connectionManager.openConnection(port);
            clientCommandsReader = new ClientCommansReader(commandManager, channel);
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
        try{
            collectionManager.loadSpaceMarine();
        } catch (NoEnvVarException e){
            e.printStackTrace();
            return;
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("jopa");
        clientCommandsReader.startReading();
        serverCommandsReader.startReading();
    }

    @Override
    public void exit() {
        try{
            connectionManager.closeConnection();
        } catch (IOException e){
            e.printStackTrace();
        }
        clientCommandsReader.stopReading();
        serverCommandsReader.stopReading();
    }
}

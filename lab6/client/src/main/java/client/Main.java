package client;


public class Main {
    public static void main(String[] args){
        Application app = new ClientApplication("localhost",61234);
        app.start();
    }
}

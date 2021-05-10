package server;


public class Main {
    public static void main(String[] args){
        Application app = new ServerApplication(61234);
        app.start(args[0]);
    }
}

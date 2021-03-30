import application.Application;
import application.ApplicationImpl;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0){
            if (!args[0].equals("")){
                Application application = new ApplicationImpl();
                application.start(args[0]);
            }
        }
    }
}

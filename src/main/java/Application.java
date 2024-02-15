import controller.Controller;
import domain.Service;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Service());
        controller.run();
    }
}
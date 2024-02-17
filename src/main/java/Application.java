import controller.Controller;
import domain.Game;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Game());
        controller.run();
    }
}

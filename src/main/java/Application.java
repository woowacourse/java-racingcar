import controller.Controller;
import domain.RandomNumberPicker;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new RandomNumberPicker());
        controller.raceTracks();
    }
}

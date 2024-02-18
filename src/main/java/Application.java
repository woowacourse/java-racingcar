import controller.Controller;
import domain.Service;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Service(), new OutputView(), new InputView());
        controller.run();
    }
}

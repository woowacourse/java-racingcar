import controller.RacingCarController;
import domain.Service;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(new Service(), new OutputView(), new InputView());
        controller.run();
    }
}

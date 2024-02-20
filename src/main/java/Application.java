import controller.RacingCarController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller =
                new RacingCarController(new OutputView(), new InputView());
        controller.run();
    }
}

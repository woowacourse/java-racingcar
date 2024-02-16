import controller.RacingController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController(new InputView(), new OutputView());
        controller.run();
    }
}

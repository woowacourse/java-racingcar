import controller.RacingController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new OutputView(), new InputView());
        racingController.run();
    }
}

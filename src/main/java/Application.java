import controller.RacingCarController;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController
                = new RacingCarController(new OutputView());
        racingCarController.run();
    }
}

import controller.RacingCarController;
import model.MovesGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController
                = new RacingCarController(new InputView(), new OutputView(), new MovesGenerator());
        racingCarController.run();
    }
}

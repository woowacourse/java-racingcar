import controller.RacingCarController;
import domain.RacingCarGame;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(new RacingCarGame(), new OutputView(), new InputView());
        controller.run();
    }
}

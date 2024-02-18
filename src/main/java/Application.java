import controller.RacingController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final RacingController controller = new RacingController(inputView, outputView);
        controller.run();
    }
}

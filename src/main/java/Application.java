import controller.RacingController;
import view.ErrorView;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(inputView, outputView);
        controller.run();
    }
}

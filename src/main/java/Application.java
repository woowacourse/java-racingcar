import controller.Controller;
import service.RacingGameService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameService racingGameService = new RacingGameService();

        Controller controller = new Controller(outputView, inputView, racingGameService);
        controller.run();
    }
}

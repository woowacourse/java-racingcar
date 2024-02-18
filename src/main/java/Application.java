import controller.RacingCarGame;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarService racingCarService = new RacingCarService();

        RacingCarGame racingCarGame = new RacingCarGame(racingCarService, inputView, outputView);

        racingCarGame.start();
    }

}

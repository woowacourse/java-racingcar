import controller.RaceController;
import util.NumberGenerator;
import util.RandomNumberGenerator;
import view.input.InputView;
import view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Game game = new Game(raceController);
        game.ready(inputView);
        game.playGame(numberGenerator, outputView);
        game.showResult(outputView);
    }
}

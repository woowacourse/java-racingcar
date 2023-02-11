import controller.RaceController;
import util.RandomNumberGenerator;
import view.input.InputView;

public class Application {

    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        InputView inputView = new InputView();
        Game game = new Game(raceController);
        game.ready(inputView);
        game.playGame(new RandomNumberGenerator());
        game.showResult();
    }
}

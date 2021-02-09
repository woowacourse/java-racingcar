import racingcargame.domain.Game;
import racingcargame.view.InputView;
import racingcargame.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(InputView.getCarNames(), InputView.getRaceCount());
        ResultView.showGameStart();
        while (game.hasRaceCount()) {
            game.race();
            ResultView.showStatus(game.getCars());
        }
        ResultView.showResult(game.getCars());
    }
}

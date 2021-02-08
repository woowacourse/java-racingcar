import racingCar.domain.Game;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int raceCount = InputView.getRaceCount();
        Game game = new Game(carNames, raceCount);
        while (game.hasRaceCount()) {
            game.race();
            ResultView.showStatus(game.getCars());
        }
        ResultView.showResult(game.getCars());
    }
}

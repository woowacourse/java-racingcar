package racingcar.controller;

import java.util.List;
import racingcar.domain.game.RacingGame;
import racingcar.domain.random.RacingcarRandomNumberGenerator;
import racingcar.receiver.NamesReceiver;
import racingcar.receiver.TryCountReceiver;
import racingcar.view.View;

public class Controller {

    private NamesReceiver namesReceiver;
    private TryCountReceiver tryCountReceiver;
    private View view;

    public Controller() {
        this.namesReceiver = new NamesReceiver();
        this.tryCountReceiver = new TryCountReceiver();
        this.view = new View();
    }

    public void runGame() {
        RacingGame racingGame = getRacingGame();

        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResults(racingGame.getMidtermResult());
        }

        view.printWinnerResult(racingGame.getWinnersResult());
    }

    private RacingGame getRacingGame() {
        return new RacingGame(inputCarNames(), inputTryCount(), new RacingcarRandomNumberGenerator());
    }

    private List<String> inputCarNames() {
        List<String> names = namesReceiver.parse(view.inputCarNames());
        return names;
    }

    private int inputTryCount() {
        int tryCount = tryCountReceiver.parse(view.inputTryCount());
        return tryCount;
    }
}

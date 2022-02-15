package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.random.RacingcarRandomNumberGenerator;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.parser.CarNameParser;
import racingcar.parser.TryCountParser;
import racingcar.util.RetryableTemplate;
import racingcar.view.View;

public class Controller {

    private CarNameParser carNameParser;
    private TryCountParser tryCountParser;
    private RacingGame racingGame;
    private View view;
    private RetryableTemplate retryableTemplate;

    public Controller(RandomNumberGenerator randomNumberGenerator) {
        this.carNameParser = new CarNameParser();
        this.tryCountParser = new TryCountParser();
        this.racingGame = new RacingGame(randomNumberGenerator);
        this.view = new View();
        this.retryableTemplate = new RetryableTemplate();
    }

    public void runGame() {
        retryableTemplate.execute(this::inputCarNames, this::handleException);
        retryableTemplate.execute(this::inputTryCount, this::handleException);

        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResults(racingGame.getMidtermResult());
        }

        view.printWinnerResult(racingGame.getWinnersResult());
    }

    private void inputCarNames() {
        List<String> names = carNameParser.parse(view.inputCarNames());
        racingGame.enrollCars(names);
    }

    private void inputTryCount() {
        int tryCount = tryCountParser.parse(view.inputTryCount());
        racingGame.initTryCount(tryCount);
    }

    private void handleException(Exception e) {
        view.printErrorMessage(e.getMessage());
    }
}

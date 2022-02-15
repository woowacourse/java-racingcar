package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.random.RacingcarRandomNumberGenerator;
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

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.init();
        controller.run();
    }

    private void init() {
        carNameParser = new CarNameParser();
        tryCountParser = new TryCountParser();
        racingGame = new RacingGame(new RacingcarRandomNumberGenerator());
        view = new View();
        retryableTemplate = new RetryableTemplate();
    }

    private void run() {
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

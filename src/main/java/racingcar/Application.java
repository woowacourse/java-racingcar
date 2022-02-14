package racingcar;

import java.util.List;
import racingcar.domain.random.DefaultRandomNumberGenerator;
import racingcar.parser.CarNameParser;
import racingcar.parser.TryCountParser;
import racingcar.util.RetryableTemplate;
import racingcar.view.View;

public class Application {

    private CarNameParser carNameParser;
    private TryCountParser tryCountParser;
    private RacingGame racingGame;
    private View view;
    private RetryableTemplate retryableTemplate;

    public static void main(String[] args) {
        Application application = new Application();
        application.init();
        application.run();
    }

    private void init() {
        carNameParser = new CarNameParser();
        tryCountParser = new TryCountParser();
        racingGame = new RacingGame(new DefaultRandomNumberGenerator());
        view = new View();
        retryableTemplate = new RetryableTemplate();
    }

    private void run() {
        retryableTemplate.execute(this::inputCarNames, this::handleException);
        retryableTemplate.execute(this::inputTryCount, this::handleException);

        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResult(racingGame.getMidtermResult());
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

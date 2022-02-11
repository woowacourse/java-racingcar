package racingcar;

import java.util.List;
import racingcar.domain.random.DefaultRandomNumberGenerator;
import racingcar.parser.CarNameParser;
import racingcar.parser.TryCountParser;
import racingcar.util.RetryableTemplate;
import racingcar.view.View;

public class Application {

    private final CarNameParser carNameParser = new CarNameParser();
    private final TryCountParser tryCountParser = new TryCountParser();
    private RacingGame racingGame;
    private View view;
    private RetryableTemplate retryableTemplate;

    public void init() {
        racingGame = new RacingGame(new DefaultRandomNumberGenerator());
        view = new View();
        retryableTemplate = new RetryableTemplate();
    }

    public void run() {
        retryableTemplate.execute(this::inputCarNames, this::handleException);
        retryableTemplate.execute(this::inputTryCount, this::handleException);

        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResult(racingGame.getMidtermResult());
        }
        view.printWinnerResult(racingGame.getWinnerResult());
    }

    public void inputCarNames() {
        List<String> names = carNameParser.parse(view.inputCarNames());
        racingGame.enrollCars(names);
    }

    public void inputTryCount() {
        racingGame.initTryCount(tryCountParser.parse(view.inputTryCount()));
    }

    private void handleException(Exception e) {
        view.printErrorMessage(e.getMessage());
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.init();
        application.run();
    }
}

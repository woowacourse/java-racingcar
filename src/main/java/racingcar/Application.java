package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.exception.RacingGameException;
import racingcar.domain.game.DefaultRandomNumberGenerator;
import racingcar.domain.game.RacingGame;
import racingcar.parser.CarNameParser;
import racingcar.parser.TryCountParser;
import racingcar.view.View;

public class Application {

    private static final View view = new View();
    private static final CarNameParser carNameParser = new CarNameParser();
    private static final TryCountParser tryCountParser = new TryCountParser();

    public static void main(String[] args) {
        try {
            run();
        } catch (RacingGameException e) {
            view.printErrorMessage(e.getMessage());
        }
    }

    public static void run() {
        List<String> names = RetryableTemplate.executeInput(Application::inputCarNames, Application::handleException);
        Integer tryCount = RetryableTemplate.executeInput(Application::inputTryCount, Application::handleException);
        RacingGame racingGame = new RacingGame(new TryCount(tryCount), new Cars(names, new DefaultRandomNumberGenerator()));

        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResult(racingGame.getMidtermResult());
        }
        view.printWinnerResult(racingGame.getWinnerResult());
    }

    public static List<String> inputCarNames() {
        List<String> names = carNameParser.parse(view.inputCarNames());
        return names;
    }

    public static Integer inputTryCount() {
        Integer tryCount = tryCountParser.parse(view.inputTryCount());
        return tryCount;
    }

    private static void handleException(Exception e) {
        view.printErrorMessage(e.getMessage());
    }
}

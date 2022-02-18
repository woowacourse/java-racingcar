package racingcar;

import java.util.List;
import racingcar.domain.exception.RacingGameException;
import racingcar.domain.game.DefaultRandomNumberGenerator;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.RacingGameBuilder;
import racingcar.parser.CarNameParser;
import racingcar.parser.TryCountParser;
import racingcar.view.View;

public class Application {

    private static final View view = new View();
    private static final CarNameParser carNameParser = new CarNameParser();
    private static final TryCountParser tryCountParser = new TryCountParser();
    private static final RacingGameBuilder racingGameBuilder = RacingGame.builder().randomNumberGenerator(new DefaultRandomNumberGenerator());

    public static void run() {
        RetryableTemplate.execute(Application::inputCarNames, Application::handleException);
        RetryableTemplate.execute(Application::inputTryCount, Application::handleException);
        RacingGame racingGame = racingGameBuilder.build();

        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResult(racingGame.getMidtermResult());
        }
        view.printWinnerResult(racingGame.getWinnerResult());
    }

    public static void inputCarNames() {
        List<String> names = carNameParser.parse(view.inputCarNames());
        racingGameBuilder.carNames(names);
    }

    public static void inputTryCount() {
        int tryCount = tryCountParser.parse(view.inputTryCount());
        racingGameBuilder.tryCount(tryCount);
    }

    private static void handleException(Exception e) {
        view.printErrorMessage(e.getMessage());
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (RacingGameException e) {
            view.printErrorMessage(e.getMessage());
        }
    }
}

package racingcar;

import java.util.List;
import racingcar.domain.game.DefaultRandomNumberGenerator;
import racingcar.domain.game.RacingGameBuilder;
import racingcar.parser.CarNameParser;
import racingcar.parser.TryCountParser;
import racingcar.domain.game.RacingGame;
import racingcar.view.View;

public class Application {

    private final CarNameParser carNameParser = new CarNameParser();
    private final TryCountParser tryCountParser = new TryCountParser();
    private RacingGameBuilder racingGameBuilder;
    private View view;

    public void init() {
        racingGameBuilder = RacingGame.builder().randomNumberGenerator(new DefaultRandomNumberGenerator());
        view = new View();
    }

    public void run() {
        RetryableTemplate.execute(this::inputCarNames, this::handleException);
        RetryableTemplate.execute(this::inputTryCount, this::handleException);
        RacingGame racingGame = racingGameBuilder.build();

        view.printResultViewTitle();
        while (!racingGame.isFinished()) {
            racingGame.proceedTurn();
            view.printMidtermResult(racingGame.getMidtermResult());
        }
        view.printWinnerResult(racingGame.getWinnerResult());
    }

    public void inputCarNames() {
        List<String> names = carNameParser.parse(view.inputCarNames());
        racingGameBuilder.carNames(names);
    }

    public void inputTryCount() {
        int tryCount = tryCountParser.parse(view.inputTryCount());
        racingGameBuilder.tryCount(tryCount);
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

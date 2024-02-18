package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.domain.car.CarName;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.domain.result.RoundResult;
import racingcar.util.ExceptionHandler;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final List<CarName> carNames = createCarNames();
        final Round round = createRound();

        final RacingGame racingGame = RacingGame.of(carNames, round);
        final List<RoundResult> roundResults = racingGame.play(new RandomNumberGenerator());

        outputView.printRoundResults(roundResults);

        outputView.printWinners(racingGame.getWinners());
    }

    private List<CarName> createCarNames() {
        return ExceptionHandler.retry(this::getCarNames, outputView::printError);
    }

    private List<CarName> getCarNames() {
        final List<String> carNames = inputView.readCarNames();

        return carNames.stream()
                .map(CarName::new)
                .toList();
    }

    private Round createRound() {
        return ExceptionHandler.retry(this::getRound, outputView::printError);
    }

    private Round getRound() {
        final int tryRound = inputView.readTryRound();
        return new Round(tryRound);
    }

}

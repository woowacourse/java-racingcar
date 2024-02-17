package racingcar.controller;

import java.util.List;
import racingcar.domain.car.CarNames;
import racingcar.domain.RacingGame;
import racingcar.domain.result.RoundResult;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.domain.Round;
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
        final CarNames carNames = ExceptionHandler.retry(this::getCarNames, outputView::printError);
        final Round round = ExceptionHandler.retry(this::getRound, outputView::printError);

        final RacingGame racingGame = RacingGame.of(carNames, round);
        final List<RoundResult> roundResults = racingGame.play(new RandomNumberGenerator());

        outputView.printRoundResults(roundResults);

        outputView.printWinners(racingGame.getWinners());
    }

    private CarNames getCarNames() {
        final String names = inputView.readCarNames();
        return CarNames.from(names);
    }

    private Round getRound() {
        final String tryRound = inputView.readTryRound();
        return Round.from(tryRound);
    }

}

package racingcar.controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final RacingGame racingGame = generateGame();
        play(racingGame);
        findWinners(racingGame);
    }

    private RacingGame generateGame() {
        final Cars cars = retry(Cars::new, inputView::readCarNames);
        final Count count = retry(Count::new, inputView::readCount);
        return new RacingGame(new RandomNumberGenerator(), cars, count);
    }

    public <T, R> R retry(final Function<T, R> function, final Supplier<T> supplier) {
        try {
            return function.apply(supplier.get());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retry(function, supplier);
        }
    }

    private void play(final RacingGame racingGame) {
        outputView.printResultMessage();
        while (racingGame.isPlayable()) {
            racingGame.play();
            outputView.printPosition(racingGame.getCurrentResult());
        }
    }

    private void findWinners(final RacingGame racingGame) {
        final List<String> winners = racingGame.findWinners();
        outputView.printWinnersMessage(winners);
    }
}

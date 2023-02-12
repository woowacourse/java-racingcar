package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.Car;
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

    public <T> T retry(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retry(supplier);
        }
    }

    public void run() {
        final RacingGame racingGame = generateGame();
        play(racingGame);
        findWinners(racingGame);
    }

    private RacingGame generateGame() {
        final List<String> carNames = retry(inputView::readCarNames);
        final int count = retry(inputView::readCount);
        return new RacingGame(new RandomNumberGenerator(), carNames, count);
    }

    private void play(final RacingGame racingGame) {
        outputView.printResultMessage();
        while (racingGame.isPlayable()) {
            final List<Car> cars = racingGame.play();
            outputView.printPosition(cars);
        }
    }

    private void findWinners(final RacingGame racingGame) {
        final List<String> winners = racingGame.findWinners();
        outputView.printWinnersMessage(winners);
    }
}

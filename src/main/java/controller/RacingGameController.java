package controller;

import domain.Car;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

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
        RacingGame racingGame = gameInitialize();
        play(racingGame);
        findWinners(racingGame);
    }

    private RacingGame gameInitialize() {
        List<String> carNames = retry(inputView::readCarNames);
        int count = retry(inputView::readCount);
        return new RacingGame(new RandomNumberGenerator(), carNames, count);
    }

    private void play(final RacingGame racingGame) {
        outputView.printResultMessage();
        while (racingGame.isPlayable()) {
            List<Car> cars = racingGame.play();
            outputView.printPosition(cars);
        }
    }

    private void findWinners(final RacingGame racingGame) {
        List<String> winners = racingGame.findWinners();
        outputView.printWinnersMessage(winners);
    }
}

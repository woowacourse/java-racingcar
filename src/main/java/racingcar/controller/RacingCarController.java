package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final RacingCars racingCars = RacingCars.from(inputView.inputCarNames());
        final int tryCount = inputView.inputTryCount();

        final RacingGame game = new RacingGame(racingCars, tryCount);
        outputView.printGameResultTitle();
        raceAllRound(game);
        outputView.printWinnerNames(game.winnerNames());
    }

    private void raceAllRound(final RacingGame game) {
        while (!game.isEnd()) {
            game.race();
            outputView.printCarsPosition(game.getCurrentRacingCarDtos());
        }
    }
}

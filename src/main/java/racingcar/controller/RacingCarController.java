package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingCars racingCars = RacingCars.from(inputView.inputCarNames());
        int tryCount = inputView.inputTryCount();

        RacingGame game = new RacingGame(racingCars, tryCount);
        outputView.printGameResultTitle();
        raceAllRound(game);
        outputView.printWinnerNames(game.winnerNames());
    }

    private void raceAllRound(RacingGame game) {
        while (!game.isEnd()) {
            game.race();
            outputView.printCarsPosition(game.getCurrentRacingCar());
        }
    }
}

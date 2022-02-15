package racingcar.controller;

import racingcar.domain.RacingCarCommander;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public RacingCarController() {
    }

    public void run() {
        RacingCars racingCars = new RacingCars(InputView.inputCarNames(), new RacingCarCommander());
        int tryCount = InputView.inputTryCount();

        RacingGame game = new RacingGame(racingCars, tryCount);
        OutputView.printGameResultTitle();
        raceAllRounds(game, racingCars);
        OutputView.printWinnerNames(game.getWinnerNames());
    }

    public void raceAllRounds(RacingGame game, RacingCars racingCars) {
        while (!game.isEnd()) {
            game.race();
            OutputView.printCarsPosition(racingCars.getRacingCarDtoList());
        }
    }
}

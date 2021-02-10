package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.domain.racingcargame.RacingCarGame;
import racingcar.domain.trynumber.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    public static void main(String[] args) {
        Cars cars = InputView.inputCarNames();
        TryNumber tryNumber = InputView.inputTryNumber();
        RacingCarGame racingCarGame = new RacingCarGame(cars, tryNumber);

        OutputView.printRunResult(racingCarGame.execute(new RandomNumberGenerator()));
        OutputView.printWinners(racingCarGame.findWinners());
    }
}

package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.util.MovingStrategy;
import racingcar.domain.car.util.RandomMovingStrategy;
import racingcar.domain.racingcargame.RacingCarGame;
import racingcar.domain.trynumber.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class RacingCarGameController {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Cars cars = InputView.inputCarNames(scanner);
        TryNumber tryNumber = InputView.inputTryNumber(scanner);

        RacingCarGame racingCarGame = new RacingCarGame(cars, tryNumber);

        MovingStrategy movingStrategy = new RandomMovingStrategy();
        OutputView.printRunResult(racingCarGame.execute(movingStrategy));
        OutputView.printWinners(racingCarGame.findWinners());
    }
}

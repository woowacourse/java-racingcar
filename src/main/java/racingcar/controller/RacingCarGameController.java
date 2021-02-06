package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.util.RandomNumberGenerator;
import racingcar.domain.racingcargame.RacingCarGame;
import racingcar.domain.trynumber.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarGameController {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Cars cars = askCarNames(scanner);
        TryNumber tryNumber = InputView.inputTryNumber(scanner);
        RacingCarGame racingCarGame = new RacingCarGame(cars, tryNumber);

        OutputView.printRunResult(racingCarGame.execute(new RandomNumberGenerator()));
        OutputView.printWinners(racingCarGame.findWinners());
    }

    private static Cars askCarNames(Scanner scanner) {
        List<String> carNames = InputView.inputCarNames(scanner);
        List<Car> carGroup = makeCarGroup(carNames);
        Cars cars = new Cars(carGroup);
        return cars;
    }

    private static List<Car> makeCarGroup(List<String> carNames) {
        List<Car> carGroup = new ArrayList<>();
        for (String carName : carNames) {
            carGroup.add(new Car(carName));
        }

        return carGroup;
    }
}

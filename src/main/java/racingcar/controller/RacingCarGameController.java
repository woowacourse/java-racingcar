package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.number.NumberGenerator;
import racingcar.domain.number.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public void playGame() {
        try {
            final Cars cars = new Cars(InputView.inputCarNames());
            final Lap lap = new Lap(InputView.inputLap());
            playRace(cars, lap);
            OutputView.printWinners(cars.getWinnersNames());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            playGame();
        }
    }

    private void playRace(final Cars cars, final Lap lap) {
        OutputView.printStartRace();
        int nowLapNumber = 0;
        while (!lap.isSameNumber(nowLapNumber)) {
            playOneLap(cars);
            nowLapNumber++;
        }
    }

    private void playOneLap(final Cars cars) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        cars.moveAllCars(numberGenerator);

        for (Car car : cars.toList()) {
            OutputView.printCarInfo(car.getName(), car.getPosition());
        }
        OutputView.printOneLine();
    }
}
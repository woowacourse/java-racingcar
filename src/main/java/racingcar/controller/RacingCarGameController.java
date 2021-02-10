package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
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
        cars.moveAllCars();
        for (Car car : cars.toList()) {
            OutputView.printCarInfo(car.getName(), car.getPosition());
        }
        OutputView.printOneLine();
    }
}
package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public void playGame() {
        try {
            Cars cars = new Cars(InputView.inputCarNames());
            Lap lap = new Lap(InputView.inputLap());
            race(cars, lap);
            Winners winners = new Winners();
            OutputView.printWinners(winners.makeWinners(cars.getCars()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            playGame();
        }
    }

    private void race(Cars cars, Lap lap) {
        OutputView.printOneLine();
        OutputView.printStartRace();
        while (!lap.isFinishAll()) {
            raceOneLap(cars);
            OutputView.printOneLine();
            lap.finishOneLap();
        }
    }

    private void raceOneLap(Cars cars) {
        for (Car car : cars.getCars()) {
            car.moveByRandomNumber(RandomNumber.make());
            OutputView.printCarInfo(car.getName().getName(), car.getPosition().toString());
        }
    }
}


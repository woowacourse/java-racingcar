package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racers;
import racingcar.domain.Trial;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Optional;

public class RacingController {
    private boolean running = true;

    public void start() {
        try {
            Cars cars = generateCars();
            Trial trial = trialSetting();
            doRace(cars, trial);
            showResult(cars);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private Cars generateCars() {
        OutputView.enterRacerNames();
        Racers racers = InputView.getRacerNames();
        return new Cars(racers);
    }

    private Trial trialSetting() {
        Optional<Trial> trial = Optional.empty();
        while (trial.equals(Optional.empty())) {
            trial = receiveTrial();
        }
        return trial.orElseThrow(IllegalArgumentException::new);
    }

    private Optional<Trial> receiveTrial() {
        try {
            OutputView.enterTrials();
            return Optional.of(InputView.getTrial());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }

    private void doRace(Cars cars, Trial trial) {
        OutputView.printResultTitle();
        for (int i = 0; i < trial.getTrial(); i++) {
            cars.move();
            OutputView.printCurrentResult(cars);
        }
    }

    private void showResult(Cars cars) {
        List<Car> winnerCars = cars.getWinnerCars(cars.getMaxPositionCar());
        OutputView.printWinners(winnerCars);
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}

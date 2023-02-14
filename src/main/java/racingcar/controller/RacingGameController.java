package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.TryCount;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private static final int RACE_START_POINT = 0;
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    public void run() {
        RacingCars cars = createCars();
        TryCount tries = getTries();

        OutputView.printResultMessage();
        raceCars(cars, tries.getTries());
        showFinalResult(cars);
    }

    private RacingCars createCars() {
        try {
            List<String> carNames = InputView.inputCarNames();
            List<Car> cars = CarFactory.generate(carNames, RACE_START_POINT);
            return new RacingCars(cars);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return createCars();
        }
    }

    private TryCount getTries() {
        try {
            int tries = InputView.inputTries();
            return new TryCount(tries);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getTries();
        }
    }

    private void raceCars(RacingCars cars, int tries) {
        NumberGenerator numberGenerator = new RandomNumberGenerator(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);

        for (int i = 0; i < tries; i++) {
            cars.moveCars(numberGenerator);
            List<CarStatus> raceResult = showRaceResult(cars);
            OutputView.printRaceResult(raceResult);
        }
    }

    private List<CarStatus> showRaceResult(RacingCars racingCars) {
        return racingCars.getCars().stream()
                .map(car -> new CarStatus(car.getName(), car.getCurrentPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    private void showFinalResult(RacingCars cars) {
        List<CarStatus> raceResult = showRaceResult(cars);
        OutputView.printRaceResult(raceResult);

        showWinners(cars);
    }

    private void showWinners(RacingCars cars) {
        List<String> winnersName = cars.pickWinnerCarNames();
        OutputView.printFinalResult(winnersName);
    }
}

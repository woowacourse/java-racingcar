package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.TryCount;
import racingcar.domain.WinnerMaker;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    private final NumberGenerator numberGenerator;

    public RacingCarController() {
        this.numberGenerator = new RandomNumberGenerator(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }

    public void run() {
        Cars cars = initCars();
        TryCount tryCount = initTryCount();
        OutputView.printResultMessage();
        race(cars, tryCount, numberGenerator);
        showFinalStatus(cars);
        prizeWinner(cars);
    }

    private Cars initCars() {
        try {
            String input = InputView.inputCarNames();
            List<String> carNames = splitCarNames(input);
            return new Cars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initCars();
        }
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private TryCount initTryCount() {
        try {
            int tries = InputView.inputTries();
            return new TryCount(tries);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initTryCount();
        }
    }

    private void race(Cars cars, TryCount tryCount, NumberGenerator numberGenerator) {
        while (!tryCount.isFinish()) {
            List<Car> movedCars = cars.moveCars(numberGenerator);
            List<CarStatus> carStatuses = mapCarsToCarStatuses(movedCars);
            tryCount.reduce();
            OutputView.printCarStatus(carStatuses);
        }
    }

    private List<CarStatus> mapCarsToCarStatuses(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarStatus(car.getName(), car.getCurrentPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    private void showFinalStatus(Cars cars) {
        List<Car> latestResult = cars.getLatestResult();
        List<CarStatus> carStatuses = mapCarsToCarStatuses(latestResult);
        OutputView.printCarStatus(carStatuses);
    }

    private void prizeWinner(Cars cars) {
        List<String> winnersName = WinnerMaker.getWinnerCarsName(cars.getLatestResult());
        OutputView.printFinalResult(winnersName);
    }
}

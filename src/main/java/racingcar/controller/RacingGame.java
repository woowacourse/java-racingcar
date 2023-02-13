package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.CarName;
import racingcar.domain.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public void run() {
        CarManager carManager = new CarManager(getCarsFromUI());
        playNTrialGame(carManager, getTrialCountFromInput());
        printResultCar(carManager);
    }

    private void printResultCar(CarManager carManager) {
        output.printFinalResult(carManager.getWinners());
    }

    private void playNTrialGame(CarManager carManager, TrialCount trial) {
        output.printExecutionResultMessage();
        executeCarMoveByTrial(carManager, trial);
    }

    private List<Car> getCarsFromUI() {
        try {
            return makeCarsByName(getCarsNameFromConsole());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getCarsFromUI();
        }
    }

    private List<Car> makeCarsByName(List<CarName> carsName) {
        return carsName.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private List<CarName> getCarsNameFromConsole() {
        return convertStringToCarName(input.getCarNames());
    }

    private List<CarName> convertStringToCarName(List<String> carNames) {
        return carNames.stream()
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    private void printErrorMessage(String message) {
        output.printError(message);
    }

    private TrialCount getTrialCountFromInput() {
        try {
            return new TrialCount(input.getTrialCount());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getTrialCountFromInput();
        }
    }

    private void executeCarMoveByTrial(CarManager manager, TrialCount count) {
        for (int i = 0; i < count.getValue(); i++) {
            manager.moveCarsRandomly();
            printExecutedResult(manager.getCars());
        }
    }

    private void printExecutedResult(List<Car> carData) {
        output.printExecutionResult(carData);
    }
}

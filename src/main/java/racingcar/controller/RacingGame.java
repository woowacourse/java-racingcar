package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public void run() {
        CarManager carManager = new CarManager(getCarsFromInput());
        output.printBlankLine();
        TrialCount count = getTrialCountFromInput();
        output.printBlankLine();
        output.printExecutionResultMessage();
        executeCarMoveByCount(carManager,count);
        output.printFinalResult(carManager.getWinners());
    }

    private List<Car> getCarsFromInput() {
        try {
            return input.getCarNames().stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getCarsFromInput();
        }
    }

    private TrialCount getTrialCountFromInput() {
        try {
            return input.getTrialCount();
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getTrialCountFromInput();
        }
    }

    private void executeCarMoveByCount(CarManager manager, TrialCount count) {
        for (int i = 0; i < count.getValue(); i++) {
            manager.moveCarsRandomly();
            printExecutedResult(manager.getCars());
            output.printBlankLine();
        }
    }

    private void printExecutedResult(List<Car> carData) {
        output.printExecutionResult(carData);
    }
}

package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.model.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    private final CarManager carManager;

    public RacingGame() {
        carManager = new CarManager(getCarsFromInput());
    }

    public void run() {
        TrialCount count = getTrialCountFromInput();
        output.printExecutionResultMessage();
        executeCarMoveByCount(count);
    }

    private List<Car> getCarsFromInput() {
        try {
            return input.getCarNames().stream()
                    .map(name -> new Car(name))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getCarsFromInput();
        }
    }

    private TrialCount getTrialCountFromInput() {
        try {
            Integer count = input.getTrialCount();
            return new TrialCount(count);
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getTrialCountFromInput();
        }
    }

    private void executeCarMoveByCount(TrialCount count) {
        for (int i = 0; i < count.getValue(); i++) {
            carManager.moveCarsRandomly();
            displayExecutedResult();
        }
    }

    private void displayExecutedResult() {
        List<Car> cars = carManager.getCars();
        cars.stream()
                .forEach(car -> output.printExecutionResult(car.getName(), car.getPosition()));
        System.out.println();
    }

    private void displayFinalResult() {
        List<Car> winners = carManager.getWinners();
        List<String> winnersNames = winners.stream().map(car -> car.getName()).collect(Collectors.toList());
        output.printFinalResult(winnersNames);
    }
}

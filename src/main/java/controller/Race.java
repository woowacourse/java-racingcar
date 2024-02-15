package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
import model.Name;
import model.TryCount;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

public class Race {
    private final NumberGenerator numberGenerator;

    public Race(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        Cars cars = createCars();
        TryCount tryCount = createTryCount();
        OutputView.printResultHeader();
        while (tryCount.hasTryCount()) {
            moveCars(cars);
            OutputView.printCarNameAndPosition(cars);
            tryCount.decreaseTryCount();
        }
        List<String> winners = cars.getWinners();
        OutputView.printWinners(winners);
    }

    private Cars createCars() {
        String[] carNames = InputView.inputCarNames();
        return Arrays.stream(carNames)
                .map(Name::new)
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    private TryCount createTryCount() {
        int tryCount = InputView.inputTryCount();
        return new TryCount(tryCount);
    }

    private void moveCars(Cars cars) {
        cars.getCars()
                .forEach(car -> {
                    int number = numberGenerator.generateNumber();
                    if (number >= 4) {
                        car.moveForward();
                    }
                });
    }
}

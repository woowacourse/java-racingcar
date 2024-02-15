package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
import model.Name;
import util.NumberGenerator;
import model.TryCount;
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
        List<String> winners = getWinners(cars);
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

    private List<String> getWinners(final Cars cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}

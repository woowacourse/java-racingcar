package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
import model.Name;
import model.TryCount;
import model.NumberGenerator;
import view.InputView;
import view.OutputView;

public class Race {

    private static final int MOVE_THRESHOLD = 4;
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public Race(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = createCars();
        TryCount tryCount = createTryCount();
        racing(cars, tryCount);
        List<String> winners = cars.getWinners();
        outputView.printWinners(winners);
    }

    private void racing(Cars cars, TryCount tryCount) {
        outputView.printResultHeader();
        while (tryCount.hasTryCount()) {
            moveCars(cars);
            outputView.printCarNameAndPosition(cars);
            tryCount.decreaseTryCount();
        }
    }

    private Cars createCars() {
        String[] carNames = inputView.inputCarNames();
        return Arrays.stream(carNames)
                .map(Name::new)
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    private TryCount createTryCount() {
        int tryCount = inputView.inputTryCount();
        return new TryCount(tryCount);
    }

    private void moveCars(Cars cars) {
        cars.getCars()
                .forEach(car -> {
                    int number = numberGenerator.generateNumber();
                    if (number >= MOVE_THRESHOLD) {
                        car.moveForward();
                    }
                });
    }
}

package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
import model.Name;
import model.TryCount;
import ui.InputView;
import ui.OutputView;
import util.NumberGenerator;

public class RaceController {
    private final NumberGenerator numberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(NumberGenerator numberGenerator, InputView inputView, OutputView outputView) {
        this.numberGenerator = numberGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = createCars();
        TryCount tryCount = createTryCount();
        outputView.printResultHeader();
        while (tryCount.hasTryCount()) {
            cars.moveCars(numberGenerator);
            outputView.printCarNameAndPosition(cars);
            tryCount.decreaseTryCount();
        }
        List<String> winners = cars.findWinners();
        outputView.printWinners(winners);
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
}

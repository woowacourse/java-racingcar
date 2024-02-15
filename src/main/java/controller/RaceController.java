package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import application.RaceService;
import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
import model.Name;
import model.TryCount;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void start() {
        Cars cars = createCars();
        TryCount tryCount = createTryCount();
        OutputView.printResultHeader();
        while (tryCount.hasTryCount()) {
            raceService.moveCars(cars);
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
}

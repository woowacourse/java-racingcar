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
import ui.InputView;
import ui.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RaceController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void start() {
        Cars cars = createCars();
        TryCount tryCount = createTryCount();
        outputView.printResultHeader();
        while (tryCount.hasTryCount()) {
            raceService.moveCars(cars);
            outputView.printCarNameAndPosition(cars);
            tryCount.decreaseTryCount();
        }
        List<String> winners = raceService.findWinners(cars);
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

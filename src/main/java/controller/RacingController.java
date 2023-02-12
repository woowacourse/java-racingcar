package controller;

import model.Car;
import model.Cars;
import model.PowerGenerator;
import view.InputView;
import view.OutputView;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView(System.in);
        outputView = new OutputView();
    }

    public void start() {
        Cars cars = new Cars(
                inputView.requestCarNames()
                .stream()
                .map(Car::new)
                .collect(toList())
        );
        int numberOfTimes = inputView.requestNumberOfTimes();
        progress(cars, numberOfTimes);
        end(cars);
    }

    private void progress(Cars cars, int numberOfTimes) {
        outputView.printResultHeader();
        IntStream.range(0, numberOfTimes)
                .forEach(i -> progressEach(cars));
    }

    private void progressEach(Cars cars) {
        cars.moveAll(new PowerGenerator(new Random()));
        outputView.printResult(cars);
    }

    private void end(Cars cars) {
        outputView.printWinners(
                cars.getWinners()
        );
    }
}

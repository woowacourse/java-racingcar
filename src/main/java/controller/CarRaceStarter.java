package controller;

import domain.Car;
import domain.Cars;
import domain.Count;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceStarter {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        Cars cars = makeCars();
        Count count = makeCount();

        raceStart(cars, count);

        List<Car> winners = cars.getWinners();
        outputView.printWinners(winners);
    }

    private Cars makeCars() {
        try {
            return collectCars(inputView.getCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return makeCars();
    }

    private Cars collectCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private Count makeCount() {
        try {
            return new Count(inputView.getCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return makeCount();
    }

    private void raceStart(Cars cars, Count count) {
        outputView.printMoveResultMessage();
        while (count.hasCount()) {
            cars.moveCars();
            count.minusOneCount();
            outputView.printMoveResult(cars);
        }
    }
}

package domain;

import view.OutputView;

import java.util.Collections;
import java.util.List;

public class RacingGame {

    private static final int WINNER = 0;

    private final Cars cars;
    private final Count count;

    public RacingGame(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public void race() {
        OutputView.printMoveResultMessage();
        while (count.hasCount()) {
            cars.moveCars(new RandomGenerator());
            count.minusOneCount();
            OutputView.printMoveResult(cars);
        }
    }

    public List<Car> getWinners() {
        List<Car> sortedCars = cars.getCars();
        sortedCars.sort(Collections.reverseOrder());
        int furthestLocation = sortedCars.get(WINNER).getLocation();
        return sortedCars.stream()
                .filter(car -> car.isSameLocation(furthestLocation))
                .toList();
    }
}

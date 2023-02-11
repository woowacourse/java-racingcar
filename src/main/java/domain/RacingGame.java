package domain;

import utils.MovingStrategy;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(List<Name> carNames, TryCount tryCount) {
        List<Car> collect = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.cars = new Cars(collect);
        this.tryCount = tryCount;
    }

    public void start(MovingStrategy movingStrategy) {
        while (tryCount.canTry()) {
            cars.moveCars(movingStrategy);
            OutputView.printAllCars(cars);
            tryCount.decreaseCount();
        }
    }

    public Cars decideWinners() {
        return cars.getWinners();
    }

}

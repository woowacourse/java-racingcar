package domain;

import utils.MovingStrategy;

import java.util.ArrayList;
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

    public List<Cars> start(MovingStrategy movingStrategy) {
        List<Cars> movingStatus = new ArrayList<>();

        while (tryCount.canTry()) {
            cars.moveCars(movingStrategy);
            movingStatus.add(new Cars(cars));
            tryCount.decreaseCount();
        }

        return movingStatus;
    }

    public Cars decideWinners() {
        return cars.getWinners();
    }

}

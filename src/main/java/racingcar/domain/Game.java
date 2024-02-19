package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.util.RandomNumber;
import racingcar.util.RandomUtils;
import racingcar.view.OutputView;

public class Game {
    private final TryCount tryCount;
    private final Cars cars;
    private final CarMoveStrategy carMoveStrategy = new CarMovement();
    private final RandomUtils randomUtil = RandomNumber.getInstance();

    public Game(final TryCount tryCount, final Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void proceed() {
        OutputView.printResultTitle();
        IntStream.range(0, tryCount.tryCount()).forEach(i -> {
            cars.move(carMoveStrategy, randomUtil);
            OutputView.printCars(cars);
        });
    }

    public Winners getWinners() {
        return Winners.from(cars.findFarthestCars());
    }
}

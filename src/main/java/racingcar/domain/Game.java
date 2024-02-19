package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class Game {
    private final TryCount tryCount;
    private final Cars cars;
    private final CarMoveStrategy carMoveStrategy = new CarMovement();
    private final NumberGenerator<Integer> numberGenerator = RandomNumberGenerator.getGenerator();

    public Game(final TryCount tryCount, final Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void proceed() {
        OutputView.printResultTitle();
        IntStream.range(0, tryCount.tryCount()).forEach(i -> {
            cars.move(carMoveStrategy, numberGenerator);
            OutputView.printCars(cars);
        });
    }

    public Winners getWinners() {
        return Winners.from(cars.findFarthestCars());
    }
}

package racingcar.domain;

import racingcar.util.RandomNumberCreator;
import racingcar.view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private List<Car> cars;
    private int numberOfTimes;

    public Racing(List<String> carNames, int numberOfTimes) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList())
        ;
        this.numberOfTimes = numberOfTimes;
    }

    public Winner run() {
        for (int i = 0; i < numberOfTimes; ++i) {
            cars.forEach(car -> car.moveOrNot(RandomNumberCreator.create(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)));
            OutputView.printMoveResult(cars);
        }

        return new Winner(cars, getCarWithMaxPosition());
    }

    public Car getCarWithMaxPosition() {
        Collections.sort(cars);
        return cars.get(0);
    }
}


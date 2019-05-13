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

    public Racing(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList())
        ;
    }

    public List<Car> run() {
        for (Car car : cars) {
            car.moveOrNot(RandomNumberCreator.create(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }

        return cars;
    }

    public Winner getWinner() {
        return new Winner(cars, getCarWithMaxPosition());
    }

    public Car getCarWithMaxPosition() {
        Collections.sort(cars);
        return cars.get(0);
    }
}


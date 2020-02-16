package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int RANDOM_VALUE_LIMIT = 10;

    private List<Car> cars;

    public Cars(Names names) {
        this.cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int createRandomValue() {
        return (int) (Math.random() * RANDOM_VALUE_LIMIT);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition(createRandomValue());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
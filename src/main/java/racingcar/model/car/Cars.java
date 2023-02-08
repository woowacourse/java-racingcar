package racingcar.model.car;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = cars;
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> movable())
                .forEach(Car::moveForward);
    }

    private boolean movable() {
        Random ran = new Random();
        int x = ran.nextInt(10);

        return x >= 4;
    }
}

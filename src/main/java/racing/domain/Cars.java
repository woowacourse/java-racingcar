package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getFirstCars() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int moveNumber = numberGenerator.generate();
            car.move(moveNumber);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

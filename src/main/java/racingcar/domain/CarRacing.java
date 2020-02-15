package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private final List<Car> cars;

    public CarRacing(List<CarData> carData) {
        this.cars = carData.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.move(new RandomMovingStrategy()));
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter((car) -> car.isWinner(maxDistance))
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}

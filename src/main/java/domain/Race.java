package domain;

import java.util.List;
import java.util.Random;

public class Race {

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_INT = 10;

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> {
            int randomInt = RANDOM.nextInt(MAX_RANDOM_INT);
            car.move(MoveStrategy.isMove(randomInt));
        });
    }

    public List<Car> findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}

package domain;

import java.util.List;
import java.util.Random;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        Random random = new Random();
        cars.forEach(car -> {
            int randomInt = random.nextInt(10);
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

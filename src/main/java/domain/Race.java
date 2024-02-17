package domain;

import java.util.List;
import java.util.Random;

public class Race {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Race(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        Random random = new Random();
        cars.forEach(car -> {
            int randomInt = random.nextInt(10);
            car.move(moveStrategy.isMove(randomInt));
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

package domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private int count;

    public Race(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public boolean hasCount() {
        return count > 0;
    }

    public void play() {
        cars.forEach(car -> car.move(RandomGenerator.getRandomNumber()));
        count--;
    }
}

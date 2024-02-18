package domain;

import java.util.List;

public class Cars {

    private final List<Car> racingCars;
    private final NumberGenerator generator;

    public Cars(final List<Car> racingCars, final NumberGenerator generator) {
        this.racingCars = racingCars;
        this.generator = generator;
    }

    public List<Car> startRounds() {
        racingCars.forEach(car -> car.moveForward(generator.generateNumber()));
        return racingCars;
    }

    public int getMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }

    public List<Car> getWinners(final int maxDistance) {
        return racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }
}

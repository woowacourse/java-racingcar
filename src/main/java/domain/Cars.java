package domain;

import java.util.List;

public class Cars {

    private final List<Car> racingCars;

    public Cars(final List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> startRounds() {
        racingCars.forEach(car -> car.moveForward(NumberGenerator.generateRandomNumber()));
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

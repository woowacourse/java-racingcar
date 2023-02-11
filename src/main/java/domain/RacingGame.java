package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MOVABLE_BOUND = 4;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(final List<String> splitCarNames, final NumberGenerator numberGenerator) {
        cars = splitCarNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        this.numberGenerator = numberGenerator;
    }

    public void start() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(final Car car) {
        int randomNumber = numberGenerator.makeDigit();
        if (randomNumber >= MOVABLE_BOUND) {
            car.move();
        }
    }

    public List<Car> getCars() {
        List<Car> copiedCars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return List.copyOf(copiedCars);
    }

    public List<Car> getWinners() {
        List<Car> copiedCars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Car furthestCar = getFurthestCar();

        return copiedCars.stream()
                .filter(car -> car.getPosition() == furthestCar.getPosition())
                .collect(Collectors.toUnmodifiableList());
    }

    private Car getFurthestCar() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get();
    }
}

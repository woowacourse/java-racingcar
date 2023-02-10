package racingcar;

import java.util.List;
import java.util.Random;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicatedName(cars);
        validateSoloPlay(cars);
        this.cars = cars;
    }

    private static void validateSoloPlay(List<Car> cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicatedName(List<Car> cars) {
        int carsSize = cars.size();
        int duplicateRemovedCount = (int) cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
        if (carsSize != duplicateRemovedCount) {
            throw new IllegalArgumentException();
        }
    }

    public void putRandomPowersToCar() {
        Random random = new Random();

        cars.forEach(car -> car.move(random.nextInt(10)));
    }
}

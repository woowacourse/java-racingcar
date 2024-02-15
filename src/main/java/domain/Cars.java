package domain;

import java.util.List;
import java.util.function.IntSupplier;

public class Cars {

    private static final int MIN_MOVABLE_DIGIT = 4;

    private final List<Car> carList;
    private final IntSupplier digitSupplier;

    public Cars(List<Car> carList, IntSupplier digitSupplier) {
        this.carList = carList;
        this.digitSupplier = digitSupplier;
    }

    public static Cars of(List<String> carNames, IntSupplier randomNumberGenerator) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList, randomNumberGenerator);
    }

    public void moveRandomly() {
        carList.forEach((car) -> {
            int randomInt = digitSupplier.getAsInt();
            car.move(randomInt >= MIN_MOVABLE_DIGIT);
        });
    }

    public List<Car> findWinner() {
        int maxPosition = carList.stream().mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }
}

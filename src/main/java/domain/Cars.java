package domain;

import java.util.List;
import java.util.function.IntSupplier;

public class Cars {

    private final List<Car> carList;
    private final IntSupplier randomNumberGenerator;

    public Cars(List<Car> carList, IntSupplier randomNumberGenerator) {
        this.carList = carList;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Cars of(List<String> carNames, IntSupplier randomNumberGenerator) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(carList, randomNumberGenerator);
    }

    public void moveRandomly() {

        carList.forEach((car) -> {
            int randomInt = randomNumberGenerator.getAsInt();
            car.move(randomInt >= 4);
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

package domain;

import java.util.List;

public class CarFactory {

    private static final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    public static Cars generateCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(randomNumberGenerator, name))
                .toList();

        return new Cars(cars);
    }
}

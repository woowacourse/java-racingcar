package utils;

import domain.Car;
import domain.Cars;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {

    private static final int DEFAULT_DISTANCE_VALUE = 0;

    public static Cars createCars(final String[] carNames) {
        List<Car> cars = makeCars(carNames);
        return new Cars(cars);
    }

    private static List<Car> makeCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(CarsFactory::makeCar)
                .collect(Collectors.toList());
    }

    private static Car makeCar(final String carName) {
        return new Car(carName, DEFAULT_DISTANCE_VALUE);
    }
}

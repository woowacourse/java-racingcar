package utils;

import domain.Car;
import domain.Cars;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarsFactory {

    private static final String SPLIT_DELIMITER = ",";
    private static final int DEFAULT_DISTANCE_VALUE = 0;

    public static Cars createCars(String carsName) {
        return new Cars(Arrays.stream(SplitCarNames.splitCarNames(carsName))
                .map(carName -> new Car(carName, DEFAULT_DISTANCE_VALUE))
                .collect(Collectors.toList()));
    }
}

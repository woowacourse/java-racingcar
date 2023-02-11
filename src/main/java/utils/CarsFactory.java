package utils;

import domain.Car;
import domain.Cars;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarsFactory {

    private static final String SPLIT_DELIMITER = ",";

    public static Cars createCars(String carsName) {
        return new Cars(Arrays.stream(carsName.split(SPLIT_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList()));
    }
}

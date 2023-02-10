package utils;

import domain.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {
    private static final String SPLIT_DELIMITER = ",";

    public static List<Car> createCars(String carsName) {
        return Arrays.stream(carsName.split(SPLIT_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

package util;

import domain.car.Car;
import domain.car.RandomDriveStrategy;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    private static final String COMMA = ",";

    private StringConvertor() {
    }

    public static List<Car> convertListSplitByComma(String value) {
        return Arrays.stream(value.split(COMMA))
                .map(name -> Car.createOnStart(name, new RandomDriveStrategy(RandomDriveStrategy::generateRandomPower))).toList();
    }
}

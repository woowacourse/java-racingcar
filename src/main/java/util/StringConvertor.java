package util;

import domain.RandomMovingCar;
import domain.car.Car;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    private static final String COMMA = ",";

    private StringConvertor() {
    }

    public static List<RandomMovingCar> convertListSplitByComma(String value) {
        return Arrays.stream(value.split(COMMA))
                .map(name -> Car.createOnStart(name))
                .map(car -> new RandomMovingCar(car, RandomMovingCar::generateRandomPower))
                .toList();
    }
}

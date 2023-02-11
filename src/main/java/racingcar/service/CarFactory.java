package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarFactory {

    private static final String SEPARATOR = ",";
    private static final int MINIMUM_PARTICIPANT = 2;

    public static List<Car> makeCars(String inputNames) throws IllegalArgumentException {
        String[] names = inputNames.split(SEPARATOR);

        if (!inputNames.contains(SEPARATOR)) {
            throw new IllegalArgumentException("[ERROR] 구분자(" + SEPARATOR + ")가 필요해요.");
        }
        if (names.length < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 " + MINIMUM_PARTICIPANT + "명이 필요해요.");
        }

        return Arrays.stream(names)
                .map(name -> name.replaceAll(" ", ""))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private static final String SEPARATOR = ",";
    private static final int MINIMUM_PARTICIPANT = 2;

    public List<Car> makeCars(String inputNames) {
        String[] names = inputNames.split(SEPARATOR);

        if (!inputNames.contains(SEPARATOR)) {
            throw new IllegalArgumentException("[ERROR] 구분자(" + SEPARATOR + ")가 필요해요.");
        }
        if (names.length < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 " + MINIMUM_PARTICIPANT + "명이 필요해요.");
        }

        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public List<Car> makeCars(String inputNames) {
        String[] names = inputNames.split(",");

        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자(,)가 필요해요.");
        }
        if (names.length < 2) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 두명이 필요해요.");
        }

        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

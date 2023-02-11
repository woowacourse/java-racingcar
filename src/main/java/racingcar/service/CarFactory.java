package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarFactory {

    private static final int MINIMUM_PARTICIPANT = 2;

    public static List<Car> makeCars(List<String> carNames) throws IllegalArgumentException {
        if (carNames.size() < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 " + MINIMUM_PARTICIPANT + "명이 필요해요.");
        }

        return carNames.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

package javaracingcar.domain;

import javaracingcar.controller.GameController;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    List<Car> cars;
    int trial;

    private Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public static Game init(List<String> carNames, int trial) {
        validateDistinctNames(carNames);
        return new Game(GameController.generateCars(carNames), trial);
    }

    private static void validateDistinctNames(List<String> carNames) {
        if (carNames.stream()
                    .distinct()
                    .count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    public int getTrial() {
        return trial;
    }
}

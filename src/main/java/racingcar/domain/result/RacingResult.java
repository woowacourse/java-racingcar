package racingcar.domain.result;

import racingcar.domain.car.Car;

import java.util.List;

public class RacingResult {
    private static final String MARK = "-";

    private final List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public static void printResult(String result) {
    }
}

package racingcar.domain;

import racingcar.constant.ErrorConstant;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerMaker {
    public static List<String> getWinnerCarsName(List<Car> cars) {
        Car winner = getWinner(cars);
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private static Car getWinner(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "비교할 자동차가 없습니다."));
    }
}

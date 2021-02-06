package racingcar.service;

import racingcar.constant.Digit;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerService {
    public List<String> getWinnerNames(Cars cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.getCars()
                .stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getMaxPosition(Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Digit.ZERO.getDigit());
    }
}

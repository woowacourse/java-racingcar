package racingcar.domain;

import racingcar.constant.ErrorConstant;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerMaker {
    public List<String> getWinnerCarsName(final List<Car> cars) {
        Position maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(car -> car.getCarName().getName())
                .collect(Collectors.toUnmodifiableList());
    }

    private Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getCurrentPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "비교할 자동차가 없습니다."));
    }
}

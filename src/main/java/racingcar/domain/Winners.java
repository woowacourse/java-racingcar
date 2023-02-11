package racingcar.domain;

import racingcar.constant.ErrorConstant;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> getWinnerCarsName() {
        Car winner = getWinner();
        return winners.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private Car getWinner() {
        return winners.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "비교할 자동차가 없습니다."));
    }
}

package racingcar.domain;

import java.util.List;

public class Referee {

    public static List<String> getWinners(Cars cars) {
        int winnerPosition = cars.getWinnerPosition();

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toList();
    }
}

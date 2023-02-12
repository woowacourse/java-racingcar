package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingcarService {

    private static final String SEPARATOR = ",";
    private static final int MINIMUM_PARTICIPANT = 2;

    public Cars makeCars(String inputNames) {
        String[] names = inputNames.split(SEPARATOR);

        if (!inputNames.contains(SEPARATOR)) {
            throw new IllegalArgumentException("[ERROR] 구분자(" + SEPARATOR + ")가 필요해요.");
        }
        if (names.length < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 " + MINIMUM_PARTICIPANT + "명이 필요해요.");
        }

        return new Cars(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move(Cars cars) {
        cars.move();
    }

    public List<Car> findWinner(Cars cars) {
        int winnerPosition = cars.findMaxPosition();

        return cars.findWinners(winnerPosition);
    }
}

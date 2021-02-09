package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private final int round;
    private int count = 0;

    public Game(int round) {
        this.round = round;
    }

    public int generateRandomInteger() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    public boolean notFinished() {
        return round != count;
    }

    public void incrementCount() {
        ++count;
    }

    public String joinWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}

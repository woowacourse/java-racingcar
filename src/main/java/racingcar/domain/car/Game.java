package racingcar.domain.car;

import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;

public class Game {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private final int round;
    private int count = 0;

    public Game(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public static int generateRandomInteger() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }

    public boolean notFinished() {
        return round != count;
    }

    public void incrementCount() {
        ++count;
    }

    public String collectWinners(){
        return CarRepository.cars().stream()
                .filter(car -> car.isMaxPosition(CarRepository.selectMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}

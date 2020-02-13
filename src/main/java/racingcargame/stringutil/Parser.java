package racingcargame.stringutil;

import racingcargame.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static final String DELIMITER = ",";

    public static List<Car> parseCars(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER));
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static int parseRound(String askRound) {
        int round = Integer.parseInt(askRound);
        if (round <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
        return round;
    }
}

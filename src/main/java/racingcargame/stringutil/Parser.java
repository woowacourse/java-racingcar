package racingcargame.stringutil;

import racingcargame.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static final String DELIMITER = ",";

    public static List<String> parseStrings(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static int parseRound(String askRound) {
        int round = Integer.parseInt(askRound);
        if (round <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
        return round;
    }
}

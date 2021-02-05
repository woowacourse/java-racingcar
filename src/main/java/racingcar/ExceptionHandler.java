package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExceptionHandler {
    private static final String NAME_SPLIT_DELIMITER = ",";
    private static final Integer MIN_TRIAL = 1;
    private static final Integer MAX_TRIAL = Integer.MAX_VALUE;

    private ExceptionHandler() {
    }

    public static List<Car> setCars(String input) {
        String[] carNames = input.split(NAME_SPLIT_DELIMITER, -1);
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public static Integer setTrial(String input) {
        try {
            Integer trial = Integer.parseInt(input);
            return isValidTrialBound(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }
    }

    private static int isValidTrialBound(Integer trial) {
        if (trial < MIN_TRIAL || trial > MAX_TRIAL) {
            throw new IllegalArgumentException("1 이상의 정수만 입력할 수 있습니다.");
        }
        return trial;
    }
}

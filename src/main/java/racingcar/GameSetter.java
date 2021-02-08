package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameSetter {

    private static final String NAME_SPLIT_DELIMITER = ",";
    private static final Integer MIN_TRIAL = 1;
    private static final Integer MAX_TRIAL = Integer.MAX_VALUE;
    private static final int MIN_CARS_LENGTH = 2;
    private static final String numberPattern = "[0-9]+";


    private GameSetter() {
    }

    public static List<Car> setCars(String input) {
        String[] carNames = input.split(NAME_SPLIT_DELIMITER, -1);
        validateCarsLength(carNames);
        validateDuplication(carNames);
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private static void validateCarsLength(String[] carNames) {
        if (carNames.length < MIN_CARS_LENGTH) {
            throw new IllegalArgumentException("자동차는 두 대 이상 입력해야 합니다.");
        }
    }

    private static void validateDuplication(String[] carNames) {
        HashSet<String> nameSet = new HashSet<>();
        Collections.addAll(nameSet, carNames);
        if (carNames.length != nameSet.size()) {
            throw new IllegalArgumentException("중복되는 이름을 입력할 수 없습니다.");
        }
    }

    public static int setTrial(String input) {
        validateNumber(input);
        try {
            int trial = Integer.parseInt(input);
            return validateBound(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "숫자는 " + MIN_TRIAL + "이상 " + MAX_TRIAL + "이하여야 합니다.");
        }
    }

    private static void validateNumber(String input) {
        if (!Pattern.matches(numberPattern, input)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static int validateBound(int trial) {
        if (trial < MIN_TRIAL) {
            throw new IllegalArgumentException(
                "숫자는 " + MIN_TRIAL + "이상 " + MAX_TRIAL + "이하여야 합니다.");
        }
        return trial;
    }
}
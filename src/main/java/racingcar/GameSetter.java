package racingcar;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameSetter {

    private static final String NAME_SPLIT_DELIMITER = ",";
    private static final Integer MIN_TRIAL = 1;
    private static final Integer MAX_TRIAL = Integer.MAX_VALUE;
    private static final int MIN_CARS_LENGTH = 2;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    private GameSetter() {
    }

    public static List<Car> setCars(String input) {
        String[] carNames = input.split(NAME_SPLIT_DELIMITER, -1);
        validateCarsLength(carNames);
        validateDuplication(carNames);

        List<Car> cars = new ArrayList<>();
        for (String name: carNames) {
            cars.add(new Car(name, 0));
        }
        return cars;
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
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        if (!matcher.matches()) {
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
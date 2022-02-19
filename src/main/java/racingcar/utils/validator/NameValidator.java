package racingcar.utils.validator;

import java.util.Arrays;
import java.util.List;

public class NameValidator extends Validator{
    private static final String DELIMITER = ",";
    private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";
    private static final String MIN_NAME_LENGTH_MESSAGE = "이름의 길이는 1글자 이상이어야 합니다.";
    public static final String NAME_LENGTH_MESSAGE = "이름의 길이는 1글자 이상 5글자 이하여야 합니다.";

    public static void validate(String input) {
        checkNull(input);
        checkEmpty(input);
        checkLastCharIsComma(input);
        checkDuplicatedNames(input);
    }

    private static void checkLastCharIsComma(String input) {
        if (isEndComma(input)) {
            throw new IllegalArgumentException(MIN_NAME_LENGTH_MESSAGE);
        }
    }

    private static boolean isEndComma(String input) {
        return input.lastIndexOf(",") == input.length() - 1;
    }

    private static void checkDuplicatedNames(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER));
        if (isContainingDuplicatedName(carNames)) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }

    private static boolean isContainingDuplicatedName(List<String> cars) {
        return cars.size() != getDistinctCarsCount(cars);
    }

    private static long getDistinctCarsCount(List<String> cars) {
        return cars.stream().distinct().count();
    }
}

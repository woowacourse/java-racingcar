package racingcar.utils.validator;

import java.util.Arrays;
import java.util.List;

public class NameValidator extends Validator{
    private static final String DELIMITER = ",";
    private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";
    public static final String NAME_LENGTH_MESSAGE = "이름의 길이는 1글자 이상 5글자 이하여야 합니다.";
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;

    public static void validateNames(String input) {
        checkNull(input);
        checkEmpty(input);
        checkDuplicatedNames(input);
    }

    public static void validateName(String input) {
        checkNull(input);
        checkEmpty(input, "이름에");
        checkNameLength(input);
    }

    private static void checkNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_MESSAGE);
        }
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

package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int MINIMUM_NATURAL_NUMBER = 1;

    private static final String CAR_NAME_PATTERN_REGEX = "^[a-zA-Z,]*$";
    private static final String ATTEMPT_COUNT_PATTERN_REGEX = "^[0-9]*$";

    private static final String NOT_ALPHA_AND_COMMA_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름은 영어와 쉼표로만 가능합니다.)";
    private static final String DUPLICATE_NAME_ERROR = "[ERROR]: 잘못된 입력입니다.(자동차 이름은 중복이 불가능합니다.)";
    private static final String NOT_NUMERIC_ERROR = "[ERROR]: 잘못된 입력입니다.(시도 횟수는 숫자만 가능합니다.)";
    private static final String MINIMUM_NATURAL_NUMBER_ERROR = "[ERROR]: 잘못된 입력입니다.(시도 횟수는 1 이상의 값만 입력이 가능합니다.)";

    private static final Pattern carNamePattern = Pattern.compile(CAR_NAME_PATTERN_REGEX);
    private static final Pattern attemptCountPattern = Pattern.compile(ATTEMPT_COUNT_PATTERN_REGEX);

    public void isValidPattern(String input) {
        Matcher matcher = carNamePattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(NOT_ALPHA_AND_COMMA_ERROR);
        }
    }

    public void isDuplicate(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        if (uniqueNames.size() != names.length) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    public void isNumeric(String input) {
        Matcher matcher = attemptCountPattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }

    public void isNaturalNumber(int input) {
        if (input < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(MINIMUM_NATURAL_NUMBER_ERROR);
        }
    }
}

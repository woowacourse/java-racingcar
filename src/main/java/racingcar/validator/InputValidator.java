package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ALPHABET_REGULAR_EXPRESSION = "[a-zA-Z]+";
    private static final String COMMA = ",";
    private static final String NUMBER_REGULAR_EXPRESSION = "[1-9]|[1-9][0-9]+";

    public static boolean validateForm(String carNames) {
        if (carNames.contains(",,")) {
            throw new IllegalArgumentException("중복된 쉼표가 있습니다.");
        }
        if (!isAlphabet(carNames)) {
            throw new IllegalArgumentException("알파벳 이외의 잘못된 문자가 포함되어 있습니다.");
        }
        if (!validateLength(carNames)) {
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과하였습니다.");
        }
        if (!overlapNames(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
        return true;
    }

    private static boolean isAlphabet(String carNames) {
        return Arrays.stream(carNames.split(COMMA)).allMatch(carName -> carName.matches(ALPHABET_REGULAR_EXPRESSION));
    }

    private static boolean validateLength(String carNames) {
        return Arrays.stream(carNames.split(COMMA)).allMatch(carName -> carName.length() <= MAX_NAME_LENGTH);
    }

    private static boolean overlapNames(String carNames) {
        return ((carNames.split(COMMA).length) == (new HashSet<>(Arrays.asList(carNames.split(COMMA))).size()));
    }

    public static boolean validateNaturalNumber(String numberOfTimes) {
        if (!numberOfTimes.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
        return true;
    }
}

package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String REGULAR_EXPRESSION_OF_ALPHABET = "[a-zA-Z]+";
    private static final String REGULAR_EXPRESSION_OF_NUMBER = "[1-9][0-9]*";

    public static boolean validateAll(String carNames) {
        if (carNames.contains(",,")) {
            System.out.println("중복된 쉼표가 있습니다. 다시 입력해주세요!");
            return false;
        }
        if (!isAlphabet(carNames)) {
            System.out.println("알파벳 이외의 잘못된 문자가 포함되어 있습니다. 다시 입력해주세요!");
            return false;
        }
        if (!validateLength(carNames)) {
            System.out.println("자동차 이름이 5글자를 초과하였습니다. 다시 입력해주세요!");
            return false;
        }
        if (!overlapNames(carNames)) {
            System.out.println("중복된 이름이 존재합니다. 다시 입력해주세요!");
            return false;
        }
        return true;
    }

    private static boolean isAlphabet(String carNames) {
        return Arrays.stream(carNames.split(",")).allMatch(carName -> carName.matches(REGULAR_EXPRESSION_OF_ALPHABET));
    }

    private static boolean validateLength(String carNames) {
        return Arrays.stream(carNames.split(",")).allMatch(carName -> carName.length() <= MAX_NAME_LENGTH);
    }

    private static boolean overlapNames(String carNames) {
        return ((carNames.split(",").length) == (new HashSet<>(Arrays.asList(carNames.split(","))).size()));
    }

    public static boolean validateNaturalNumber(String numberOfTimes) {
        if (!numberOfTimes.matches(REGULAR_EXPRESSION_OF_NUMBER)) {
            System.out.println("자연수가 아닙니다. 다시 입력해주세요!");
            return false;
        }
        return true;
    }
}

package view;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidateInput {

    private static final String NO_NAME_ERROR_MESSAGE = "이름 입력값이 없습니다.";
    private static final String INVALID_NAME_ERROR_MESSAGE = "유효하지 않은 이름입니다.";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "입력된 횟수가 숫자가 아니라 문자입니다.";

    public static void validateInput(String carNames, String round) {
        checkCarNames(carNames);
        checkRound(round);
    }

    private static void checkRound(String round) {
        isInteger(round);
    }

    static void isInteger(String round) {
        try {
            Integer.parseInt(round);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    static void checkCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(NO_NAME_ERROR_MESSAGE);
        }
        ArrayList<String> tempCarNames = new ArrayList<>(Arrays.asList(carNames.split(",")));
        checkNameEmpty(tempCarNames);
    }

    private static void checkNameEmpty(ArrayList<String> tempCarNames) {
        if (tempCarNames == null || tempCarNames.isEmpty()) {
            throw new IllegalArgumentException(NO_NAME_ERROR_MESSAGE);
        }
        tempCarNames.stream()
                .filter(x -> x == null || x.isEmpty())
                .forEach(x -> {
                    throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
                });
    }
}

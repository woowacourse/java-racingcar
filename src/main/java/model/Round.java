package model;

import static util.ErrorMessage.*;

import java.util.regex.Pattern;

import static view.OutputView.ERROR_PREFIX;

public class Round {

    private static final String NATURAL_FORMAT_REGEX = "^[\\d]*$";

    private int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String round) {
        validate(round);
        return new Round(Integer.parseInt(round));
    }

    private static void validate(String input) {
        checkIsNull(input);
        checkIsNumber(input);
        checkIsZero(input);
    }

    private static void checkIsNull(String input) {
        if (input == null) {
<<<<<<< HEAD
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수를 입력해 주십시오.");
=======
            throw new IllegalArgumentException(ERROR_ROUND_IS_NULL.getMessage());
>>>>>>> bf2e5d4 (refactor: 에러 메시지 Enum 클래스로 상수화)
        }
    }

    private static void checkIsNumber(String input) {
        if (!Pattern.matches(NATURAL_FORMAT_REGEX, input)) {
<<<<<<< HEAD
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수는 자연수여야 합니다.");
=======
            throw new IllegalArgumentException(ERROR_ROUND_IS_NATURAL_NUMBER.getMessage());
>>>>>>> bf2e5d4 (refactor: 에러 메시지 Enum 클래스로 상수화)
        }
    }

    private static void checkIsZero(String input) {
<<<<<<< HEAD
        if (input.equals(0)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수를 입력해 주세요.");
=======
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException(ERROR_ROUND_IS_NATURAL_NUMBER.getMessage());
>>>>>>> bf2e5d4 (refactor: 에러 메시지 Enum 클래스로 상수화)
        }
    }

    public int getRound() {
        return round;
    }
}

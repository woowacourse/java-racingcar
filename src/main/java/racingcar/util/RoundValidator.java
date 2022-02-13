package racingcar.util;

public class RoundValidator {
    private static final int POSITIVE_INTEGER = 1;

    public static void validate(String round) {
        checkDigit(round);
        checkPositive(round);
    }

    private static void checkDigit(String round) {
        if (!round.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("라운드 횟수는 숫자만 가능합니다.");
        }
    }

    private static void checkPositive(String round) {
        if (Integer.parseInt(round) < POSITIVE_INTEGER) {
            throw new IllegalArgumentException("라운드 횟수는 자연수만 가능합니다.");
        }
    }
}

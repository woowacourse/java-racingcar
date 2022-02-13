package racingcar.util;

public class RoundValidator {
    private static final int CAN_START = 1;

    public static void validate(String round) {
        checkDigit(round);
        checkPositive(round);
    }

    private static void checkDigit(String round) {
        if (!round.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkPositive(String round) {
        if (Integer.parseInt(round) < CAN_START) {
            throw new IllegalArgumentException();
        }
    }
}

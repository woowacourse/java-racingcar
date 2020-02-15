package racingcar.domain;

public class Round {
    private static final int ZERO = 0;
    private int round;

    public Round(String input) {
        int round = validateIsNumber(input);
        validateIsPositiveNumber(round);
        this.round = round;
    }

    public static int validateIsNumber(String input) throws IllegalArgumentException {
       try {
           return Integer.parseInt(input);
       } catch (NumberFormatException e) {
           throw new IllegalArgumentException("시도할 회수는 숫자이어야 합니다.");
       }
    }

    public static void validateIsPositiveNumber(int parsedNumber) {
        if (isNotPositiveNumber(parsedNumber)) {
            throw new IllegalArgumentException("시도할 회수는 양수이어야 합니다.");
        }
    }

    private static boolean isNotPositiveNumber(int parsedNumber) {
        return parsedNumber <= ZERO;
    }

    public boolean isGoing() {
        if (round > ZERO) {
            round--;
            return true;
        }
        return false;
    }
}
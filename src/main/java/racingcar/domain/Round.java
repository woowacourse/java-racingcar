package racingcar.domain;

public class Round {
    private static final int ZERO = 0;

    private int round;

    public Round(String input) {
        this.round = validateIsNumber(input);
        this.round = validateIsNegativeNumber(this.round);
    }

    public static int validateIsNumber(String input) throws IllegalArgumentException {
       try {
           return Integer.parseInt(input);
       } catch (NumberFormatException e) {
           throw new IllegalArgumentException("시도할 회수는 숫자이어야 합니다.");
       }
    }

    public static int validateIsNegativeNumber(int parsedNumber) {
        if (isNotPositiveNumber(parsedNumber)) {
            throw new IllegalArgumentException("시도할 회수는 양수이어야 합니다.");
        }
        return parsedNumber;
    }

    private static boolean isNotPositiveNumber(int parsedNumber) {
        return parsedNumber <= ZERO;
    }

    public boolean canGo() {
        return this.round > ZERO;
    }

    public int reduce() {
        return this.round--;
    }
}

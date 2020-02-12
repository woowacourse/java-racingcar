package racingcar.domain;

public class Round {
    private static final int ZERO = 0;
    private int round;

    public Round(String input) {
        int temp = validateIsNumber(input);
        validateIsNegativeNumber(temp);
        this.round = temp;
    }

    public static int validateIsNumber(String input) throws NumberFormatException {
        return  Integer.parseInt(input);
    }

    public static void validateIsNegativeNumber(int parsedNumber) {
        if (isNotPositiveNumber(parsedNumber)) {
            throw new IllegalArgumentException("경주 라운드는 양수이어야 합니다.");
        }
    }

    private static boolean isNotPositiveNumber(int parsedNumber) {
        return parsedNumber <= ZERO;
    }
}

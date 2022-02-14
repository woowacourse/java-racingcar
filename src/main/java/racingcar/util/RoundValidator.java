package racingcar.util;

public class RoundValidator {
    private static final int POSITIVE_INTEGER = 1;

    public static void checkPositive(int rounds) {
        if (rounds < POSITIVE_INTEGER) {
            throw new IllegalArgumentException("라운드 횟수는 자연수만 가능합니다.");
        }
    }
}

package racingcar.validator;

public class RoundValidator {

    private RoundValidator() {
    }

    public static void checkIsValid(int round) {
        if (!isPositive(round)) {
            throw new IllegalArgumentException("Rounds must be positive");
        }
    }

    private static boolean isPositive(int round) {
        return round > 0;
    }
}

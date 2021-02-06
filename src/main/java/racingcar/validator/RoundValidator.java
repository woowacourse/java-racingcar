package racingcar.validator;

public class RoundValidator {

    public static void isPositive(int round) {
        if(round <= 0) {
            throw new IllegalArgumentException("Round must be positive");
        }
    }
}

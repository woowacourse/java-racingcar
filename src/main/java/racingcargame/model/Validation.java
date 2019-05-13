package racingcargame.model;

public class Validation {

    public static void validNegativeNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
    }
}

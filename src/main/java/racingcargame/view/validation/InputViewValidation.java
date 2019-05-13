package racingcargame.view.validation;

public class InputViewValidation {

    public static void validNegativeNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
    }
}

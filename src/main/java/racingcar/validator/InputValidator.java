package racingcar.validator;

public class InputValidator {

    private InputValidator() {
    }

    public static void checkIsNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Enter numeric value");
        }
    }
}

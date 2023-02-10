package validation;

public class InputValidator extends Validator<String> {

    public static final InputValidator INPUT_VALIDATOR = new InputValidator();

    private static final String EMPTY_INPUT = "입력값이 없습니다.";

    private InputValidator() {
    }

    @Override
    public void validate(final String input) {
        validateNotEmpty(input);
    }

    private void validateNotEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throwError(EMPTY_INPUT);
        }
    }
}

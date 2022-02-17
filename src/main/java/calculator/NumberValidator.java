package calculator;

import calculator.exception.NumberExceptionStatus;
import calculator.exception.WrongArgumentException;

public class NumberValidator {

    private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator();

    private NumberValidator() {
    }

    public static void validateNumber(final int number) {
        NUMBER_VALIDATOR.validateNumberIsNegative(number);
    }

    private void validateNumberIsNegative(final int number) {
        if (number < 0) {
            throw new WrongArgumentException(NumberExceptionStatus.NUMBER_IS_NEGATIVE);
        }
    }

}

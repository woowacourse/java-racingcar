package calculator;

import calculator.exception.NumberIsNegativeException;

public class NumberValidator {

    private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator();

    private NumberValidator() { }

    public static void validateNumber(int number) {
        NUMBER_VALIDATOR.validateNumberIsNegative(number);
    }

    private void validateNumberIsNegative(int number) {
        if (number < 0) {
            throw new NumberIsNegativeException();
        }
    }

}

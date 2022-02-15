package calculator;

import static calculator.exception.NumberExceptionStatus.NUMBER_IS_NEGATIVE_EXCEPTION_STATUS;

import calculator.exception.CalculatorException;

public class NumberValidator {

    private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator();

    private NumberValidator() { }

    public static void validateNumber(int number) {
        NUMBER_VALIDATOR.validateNumberIsNegative(number);
    }

    private void validateNumberIsNegative(int number) {
        if (number < 0) {
            throw new CalculatorException(NUMBER_IS_NEGATIVE_EXCEPTION_STATUS.getMessage());
        }
    }

}

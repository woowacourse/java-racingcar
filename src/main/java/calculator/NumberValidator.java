package calculator;

import calculator.exception.NumberIsNegativeException;

public class NumberValidator {

    private static final NumberValidator instance = new NumberValidator();

    public static void validateNumber(int number) {
        instance.validateNumberIsNegative(number);
    }

    private void validateNumberIsNegative(int number) {
        if (isNumberNegative(number)) {
            throw new NumberIsNegativeException();
        }
    }

    private boolean isNumberNegative(int number) {
        return (number < 0);
    }

}

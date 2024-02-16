package utils;

public class InputValidator {

    public static void tryNumberValidator(String number) {
        int validateNumber = validateNumber(number);
        validateNegativeNumber(validateNumber);
    }




    private static int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    private static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }
}

package calculator.utils;

public class Validator {
    private static final int ZERO = 0;

    public static void validateNumber(String[] numbers) {
        for (String number : numbers) {
            if (!isNumeric(number))
                throw new RuntimeException();
            if (Double.parseDouble(number) < ZERO) {
                throw new RuntimeException();
            }
        }
    }

    private static boolean isNumeric(String value) {
        if (value == null) {
            return false;
        }
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

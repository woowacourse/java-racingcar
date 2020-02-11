package calculator;

public class Calculator {
    public static String[] splitString(String input) {
        String delimiter = ",|:";

        if (input.charAt(0) == '/') {
            delimiter = input.substring(2, 3);
            input = input.substring(5);
        }

        return input.split(delimiter);
    }

    public static int calculate(String[] numbers) throws NumberFormatException {
        int result = 0;

        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);

            validatePositiveNumber(parsedNumber);

            result += parsedNumber;
        }

        return result;
    }

    private static void validatePositiveNumber(int parsedNumber) {
        if (isNegativeNumber(parsedNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNegativeNumber(int parsedNumber) {
        return parsedNumber < 0;
    }
}
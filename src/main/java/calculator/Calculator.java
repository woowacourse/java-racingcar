package calculator;

public class Calculator {
    public static String[] splitString(String input) {
        String delimiter = ",|:";

        if (input.charAt(0) == '/') {
            delimiter = input.substring(2, 3);
            input = input.substring(4);
        }

        return input.split(delimiter);
    }

    public static int calculate(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);

            result += parsedNumber;
        }

        return result;
    }
}
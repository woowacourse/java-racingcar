package calculator;

public class Calculator {

    public static int sum(String input) {
        if (!validateNullAndBlank(input)) {
            return 0;
        }
        String[] numbers = input.split(",");
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static boolean validateNullAndBlank(String input) {
        return input != null && !input.isEmpty();
    }
}

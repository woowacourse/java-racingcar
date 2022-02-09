package calculator;

public class Calculator {

    public static int sum(String input) {
        if (!validateNullAndBlank(input)) {
            return 0;
        }
        return Integer.parseInt(input);
    }

    private static boolean validateNullAndBlank(String input) {
        return input != null && !input.isEmpty();
    }
}

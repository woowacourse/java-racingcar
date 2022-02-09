package calculator;

public class Calculator {

    public static int sum(String input) {
        if (!validateNullAndBlank(input)) {
            return 0;
        }
        int[] numbers = parseStringsToInts(splitByDelimiter(input));

        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static String[] splitByDelimiter(String input) {
        return input.split(",|:");
    }

    private static int[] parseStringsToInts(String[] numbers) {
        int[] results = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            results[i] = Integer.parseInt(numbers[i]);
        }
        return results;
    }

    private static boolean validateNullAndBlank(String input) {
        return input != null && !input.isEmpty();
    }
}

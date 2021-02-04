package calculator;

public class StringCalculator {
    public static int splitAndSum(String input) {
        int result = 0;
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split("[,:]");
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}

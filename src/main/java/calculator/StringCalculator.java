package calculator;

public class StringCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] separatedValues = input.split(",|:");
        for (String separatedValue : separatedValues) {
            sum += Integer.parseInt(separatedValue);
        }
        return Integer.parseInt(input);
    }
}

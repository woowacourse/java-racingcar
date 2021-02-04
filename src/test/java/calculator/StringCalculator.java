package calculator;

public class StringCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input == "") {
            return 0;
        }
        return Integer.parseInt(input);
    }
}

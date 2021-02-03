package calculator;

public class StringCalculator {
    public static int splitAndSum(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            return Integer.parseInt(string);
        }

        return 1;
    }
}

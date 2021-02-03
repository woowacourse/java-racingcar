package calculator;

public class StringCalculator {
    public static int splitAndSum(String inputStr) {
        if (isEmptyOrNull(inputStr)) {
            return 0;
        }

        return -1;
    }

    private static boolean isEmptyOrNull(String inputStr) {
        return ("".equals(inputStr) || inputStr == null);
    }
}

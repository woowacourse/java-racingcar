package calculator;

public class StringCalculator {

    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(inputString);
    }
}

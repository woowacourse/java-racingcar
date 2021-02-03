package stringcalculator.domain;

public class StringCalculator {
    public static int splitAndSum(String input) {
        if(isNullOrBlank(input)) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }



        return 1;
    }

    private static boolean isNullOrBlank(String input) {
        if(input == null || input.isEmpty()){
            return true;
        }

        return false;
    }
}

package calculator;

public class StringCalculator {

    static int splitAndSum(String input) {
        if (checkIfNull(input) || checkIfEmpty(input)) {
            return 0;
        }
        return 0;
    }

    static private boolean checkIfNull(String input) {
        return input == null;
    }

    static private boolean checkIfEmpty(String input) {
        return input.isEmpty();
    }

}

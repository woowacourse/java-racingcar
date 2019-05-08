package calculator;

import java.util.Arrays;

public class Validator {
    private static String[] values;

    public static boolean validateAll(String value) {
        values = value.split(" ");
        if (!validateLength()) {
            System.out.println("validateLength!");
            return false;
        }
        if (!validateForm()) {
            System.out.println("validateForm!");
            return false;
        }
        if (!dividedZero(value)) {
            System.out.println("dividedZero!");
            return false;
        }
        if(!validateOrderOfNumbers() || !validateOrderOfOperator()) {
            System.out.println("validateOrderOfNumbers!");
            return false;
        }
        return true;
    }

    private static boolean validateLength() {
        return (values.length < 3) ? false : true;
    }

    private static boolean validateForm() {
        return !(Arrays.stream(values).anyMatch(x -> !isNumeric(x) && !(x.matches("[+|\\-|*|/]"))));
    }

    private static boolean dividedZero(String value) {
        return !(value.contains("/ 0"));
    }

    private static boolean validateOrderOfNumbers() {
        int wrongCount = 0;
        for (int i = 0; i < values.length; i += 2)
            wrongCount += (isNumeric(values[i])) ? 0 : 1;
        return (wrongCount > 0) ? false : true;
    }

    private static boolean validateOrderOfOperator() {
        int wrongCount = 0;
        for (int i = 1; i < values.length; i += 2)
            wrongCount += (values[i].matches("[+|\\-|*|/]")) ? 0 : 1;
        return (wrongCount > 0) ? false : true;
    }

    public static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

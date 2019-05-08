package calculator;

import java.util.Scanner;

public class StringCalculator {
    private static final String BLANK = " ";
    private int leftValue;
    private int rightValue;
    private String operator = null;

    public int calculate (String input) {
        String[] values = splitWithBlank(input);

        for (String value : values) {
            if (isInteger(value)) {
                if (operator == null) {
                    leftValue = Integer.parseInt(value);
                } else {
                    rightValue = Integer.parseInt(value);
                    if (operator.equals("+")) {
                        return (leftValue + rightValue);
                    }
                }
            } else {
                operator = value;
            }
        }

        return -1;
    }

    private String[] splitWithBlank(String value) {
        return value.split(BLANK);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

    }
}

package calculator;

import java.util.Arrays;

public class Validator {
    private static final int MIN_LENGTH = 3;
    private static final String DIVIDE_ZERO_FORM = "/ 0";
    private static final String OPERATOR_REGULAR_EXPRESSION = "[+|\\-|*|/]";

    private String value;
    private String[] values;

    public Validator(String value, String[] values) {
        this.value = value;
        this.values = values;
    }

    public boolean validateAll() {
        if (!validateLength()) {
            throw new IllegalArgumentException("validateLength! 다시 입력해주세요!");
        }
        if (!validateForm()) {
            throw new IllegalArgumentException("validateForm! 다시 입력해주세요!");
        }
        if (!dividedZero()) {
            throw new IllegalArgumentException("validateForm! 다시 입력해주세요!");
        }
        if (!validateOrderOfNumbers() || !validateOrderOfOperator()) {
            throw new IllegalArgumentException("validateForm! 다시 입력해주세요!");
        }
        return true;
    }

    boolean validateLength() {
        return (values.length < MIN_LENGTH) ? false : true;
    }

    boolean validateForm() {
        return !(Arrays.stream(values).anyMatch(x -> !isNumeric(x) && !(x.matches(OPERATOR_REGULAR_EXPRESSION))));
    }

    boolean dividedZero() {
        return !(value.contains(DIVIDE_ZERO_FORM));
    }

    boolean validateOrderOfNumbers() {
        int wrongCount = 0;
        for (int i = 0; i < values.length; i += 2)
            wrongCount += (isNumeric(values[i])) ? 0 : 1;
        return (wrongCount > 0) ? false : true;
    }

    boolean validateOrderOfOperator() {
        int wrongCount = 0;
        for (int i = 1; i < values.length; i += 2)
            wrongCount += (values[i].matches(OPERATOR_REGULAR_EXPRESSION)) ? 0 : 1;
        return (wrongCount > 0) ? false : true;
    }

    boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package calculator;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringCalculator {
    private static final Set<String> OPERATORS = Stream.of("+", "-", "*", "/").collect(Collectors.toSet());
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*$)");
    private static final String BLANK = " ";
    private static final String DIV_ERROR_MENT = "나누는 숫자는 0 이 될 수 없습니다.";
    private static final String INPUT_ERROR_MENT = "입력이 잘못 되었습니다.";

    private int plus(int number, int totalnumber) {
        return totalnumber + number;
    }

    private int minus(int number, int totalnumber) {
        return totalnumber - number;
    }

    private int mul(int number, int totalnumber) {
        return totalnumber * number;
    }

    private int div(int number, int totalnumber) {
        if (number == 0) {
            throw new IllegalArgumentException(DIV_ERROR_MENT);
        }
        return totalnumber / number;
    }

    private int calculate(int number, int totalNumber, String operator) {
        if (operator.equals("+")) {
            return plus(number, totalNumber);
        }
        if (operator.equals("-")) {
            return minus(number, totalNumber);
        }
        if (operator.equals("*")) {
            return mul(number, totalNumber);
        }
        return div(number, totalNumber);
    }

    int getResult(String str) {
        String[] values = str.split(BLANK);
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = calculate(Integer.parseInt(values[i + 1]), result, values[i]);
        }
        return result;
    }

    boolean checkInputValid(String value) {
        value = value.trim().replaceAll(" +", BLANK);
        String[] values = value.split(BLANK);
        try {
            checkEvenValue(values);
            checkOddValue(values);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void checkEvenValue(String[] values) {
        for (int i = 0; i < values.length; i += 2) {
            try {
                checkNumber(values[i]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void checkNumber(String value) {
        Matcher m = NUMBER_PATTERN.matcher(value);
        if (m.find()) {
            throw new IllegalArgumentException(INPUT_ERROR_MENT);
        }
    }

    private void checkOddValue(String[] values) {
        for (int i = 1; i < values.length; i += 2) {
            try {
                checkOperator(values[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void checkOperator(String str) {
        if (OPERATORS.contains(str)) {
            throw new IllegalArgumentException(INPUT_ERROR_MENT);
        }
    }
}
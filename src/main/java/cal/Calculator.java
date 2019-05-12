/*
 * @(#)Calculator.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package cal;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 12일
 */
class Calculator {
    /*계산기 전체적인 로직에 관한 클래스*/
    private static String PLUS = "+";
    private static String MINUS = "-";
    private static String MULTIPLY = "*";
    private static String DEVIDE = "/";

    private int value;

    int execute(String expression) {
        String[] parsedExpression = splitExpression(expression);
        checkValidExpressionFormat(parsedExpression);
        checkValidNumberOfToken(parsedExpression);
        this.value = parseInt(parsedExpression[0]);
        for (int i = 1; i < parsedExpression.length; i += 2) {
            String operator = parsedExpression[i];
            int number = parseInt(parsedExpression[i + 1]);
            calculate(operator, number);
        }
        return value;
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }

    private String[] splitExpression(String expression) {
        return expression.split(" ");
    }

    private void checkValidNumberOfToken(String[] expression) {
        if (expression.length < 3 || expression.length % 2 == 0) {
            throw new IllegalArgumentException("항의 개수 오류");
        }
    }

    private void checkValidExpressionFormat(String[] expression) {
        for (int i = 0; i < expression.length; i += 2) {
            isInteger(expression[i]);
        }
        for (int i = 1; i < expression.length; i += 2) {
            isOperator(expression[i]);
        }
    }

    private void isOperator(String expression) {
        if (!(expression.equals("+") || expression.equals("-") || expression.equals("*") || expression.equals("/"))){
            throw new IllegalArgumentException("연산자 입력 위치에 연산자 이 외의 값 입력 오류");
        }
    }

    private void isInteger(String expression) {
        try {
            Integer.parseInt(expression);
        } catch (NumberFormatException e) {
            new Exception("정수 입력 위치에 정수 이 외의 값 입력 오류");
        }
    }


    private void calculate(String operator, int number) {
        if (operator.equals(PLUS)) {
            add(number);
        }

        if (operator.equals(MINUS)) {
            subtract(number);
        }

        if (operator.equals(MULTIPLY)) {
            multiply(number);
        }

        if (operator.equals(DEVIDE)) {
            devide(number);
        }
    }

    private void add(int number) {
        value = Math.addExact(value, number);
    }

    private void subtract(int number) {
        value = Math.subtractExact(value, number);
    }

    private void multiply(int number) {
        value = Math.multiplyExact(value, number);
    }

    private void devide(int number) {
        value /= number;
    }
}

/*
 * @(#)Calculator.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package cal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 12일
 */
class Calculator {
    /*계산기 전체적인 로직에 관한 클래스*/
    private int value;

    private static Map<String, Function<Integer, Integer>> calculatrMaaping = new HashMap<>();

    public Calculator() {
        calculatrMaaping.put("+", (number) -> (this.value + number));
        calculatrMaaping.put("-", (number) -> this.value - number);
        calculatrMaaping.put("*", (number) -> this.value * number);
        calculatrMaaping.put("/", (number) -> this.value / number);
    }

    public int execute(String expression) {
        String[] parsedExpression = splitExpression(expression);
        checkValidNumberOfToken(parsedExpression);
        checkValidExpressionFormat(parsedExpression);
        this.value = parseInt(parsedExpression[0]);
        for (int i = 1; i < parsedExpression.length; i += 2) {
            String operator = parsedExpression[i];
            int number = parseInt(parsedExpression[i + 1]);
            this.value = calculatrMaaping.get(operator).apply(number);
        }
        return value;
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

    private void isInteger(String expression) {
        try {
            Integer.parseInt(expression);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수 입력 위치에 정수 이 외의 값 입력 오류");
        }
    }

    private void isOperator(String expression) {
        if (!(expression.equals("+") || expression.equals("-") || expression.equals("*") || expression.equals("/"))) {
            throw new IllegalArgumentException("연산자 입력 위치에 연산자 이 외의 값 입력 오류");
        }
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.execute("5 + a"));
    }
}

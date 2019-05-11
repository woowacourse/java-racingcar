package calculator;

import java.util.function.BiFunction;

public enum Calculator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-",  (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String operator;
    private BiFunction<Double, Double, Double> calculation;

    Calculator(String operator, BiFunction<Double, Double, Double> calculation) {
        this.operator = operator;
        this.calculation = calculation;
    }

    public double calculate(double a, double b) {
        return calculation.apply(a,b);
    }

    public static Calculator selectCalculator(String operator) {
        for (Calculator cal : Calculator.values()) {
            if (cal.operator.equals(operator)) {
                return cal;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자가 입력되었습니다.");
    }
}

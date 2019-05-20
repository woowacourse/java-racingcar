package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTI("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    public BiFunction<Integer, Integer, Integer> function;
    private String operatorString;

    Operator(String operatorString, BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
        this.operatorString = operatorString;
    }

    public static boolean hasOperatorCode(String input) {
        return Arrays.stream(Operator.values())
                .anyMatch(operator -> operator.getOperatorCode().equals(input));
    }

    private String getOperatorCode() {
        return this.operatorString;
    }

    public static Operator getOperatorByCode(String code) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getOperatorCode().equals(code))
                .findAny().get();
    }
}

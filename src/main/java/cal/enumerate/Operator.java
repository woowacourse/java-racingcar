package cal.enumerate;

import java.util.function.BiFunction;

enum Operator {
    ADD("+", (d1, d2) -> d1 + d2),
    SUB("-", (d1, d2) -> d1 - d2),
    MUL("*", (d1, d2) -> d1 * d2),
    DIV("/", (d1, d2) -> d1 / d2);

    public String operator;
    public BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public double calculate(double num1, double num2) {
        return this.expression.apply(num1, num2);
    }
}

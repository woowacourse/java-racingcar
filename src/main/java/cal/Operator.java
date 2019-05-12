//package cal;
//
//import java.util.function.DoubleBinaryOperator;
//
//enum Operator {
//
//    ADD("+", (d1, d2) -> d1 + d2), // or Double::sum
//    SUB("-", (d1, d2) -> d1 - d2),
//    MUL("*", (d1, d2) -> d1 * d2),
//    DIV("/", (d1, d2) -> d1 / d2);
//
//    private final String symbol;
//    private final DoubleBinaryOperator operator;
//
//    private Operator(String symbol, DoubleBinaryOperator operator) {
//        this.symbol = symbol;
//        this.operator = operator;
//    }
//
//    public double getResult(double d1, double d2) {
//        return operator.applyAsDouble(d1, d2);
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//}

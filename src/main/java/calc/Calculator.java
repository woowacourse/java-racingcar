package calc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Calculator {
    public static double val;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("수식을 입력하여 주십시오.");
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(input.nextLine().split(" ")));
        try {
            calculateTokens(tokens);
            System.out.println("감사합니다.\n결과값은 " + val + "입니다.");
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }

    }

    public static void calculateTokens(ArrayList<String> tokens) {
        val = .0;
        tokens.add(0, "+");
        calculate(tokens);
    }

    private static boolean calculate(ArrayList<String> tokens) {
        val = convertSymbolToEnum(tokens.remove(0)).calculate(val, Double.parseDouble(tokens.remove(0)));
        return tokens.isEmpty() || calculate(tokens);
    }

    private static Operator convertSymbolToEnum(String symbol) {
        final String conversionTable[] = { "PLUS", "MINUS", "MULTIPLY", "DIVIDE" };
        return Operator.valueOf(conversionTable["+-*/".indexOf(symbol)]);
    }
}

enum Operator {
    PLUS((lhs, rhs) -> lhs + rhs),
    MINUS((lhs, rhs) -> lhs - rhs),
    MULTIPLY((lhs, rhs) -> lhs * rhs),
    DIVIDE((lhs, rhs) -> lhs / rhs);

    private BiFunction<Double, Double, Double> func;

    Operator(BiFunction<Double, Double, Double> func) {
        this.func = func;
    }

    public double calculate(double lhs, double rhs) {
        return func.apply(lhs, rhs);
    }
}
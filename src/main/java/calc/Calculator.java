package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Calculator {
    static final Operator[] functionTable = { Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("수식을 입력하여 주십시오.");
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(input.nextLine().split(" ")));
        try {
            System.out.println("감사합니다.\n결과값은 " + calculateTokens(tokens)+ "입니다.");
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }

    }

    public static double calculateTokens(ArrayList<String> tokens) {
        tokens.add(0, "+");
        return calculate(tokens, 0);
    }

    private static double calculate(ArrayList<String> tokens, double acc) {
        double exp = calculateExpression(acc, tokens.remove(0), Double.parseDouble(tokens.remove(0)));
        HashMap<Boolean, Supplier<Double>> result = new HashMap<>();
        result.put(true, () -> exp);
        result.put(false, () -> calculate(tokens, exp));
        return result.get(tokens.isEmpty()).get();
    }

    private static double calculateExpression(double lhs, String operator, double rhs) {
        return functionTable["+-*/".indexOf((operator))].calculate(lhs, rhs);
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
package calc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final List<String> tokens;
    private double result = .0;

    Calculator(String line) {
        tokens = Arrays.asList(line.split(" ")).stream()
                .filter(x -> !x.equals("") && !x.equals(" "))
                .map(x -> x.trim())
                .collect(Collectors.toList());
        tokens.add(0, "+");
        calculate();
    }

    private boolean calculate() {
        result = convertSymbolToOperator(tokens.remove(0)).calculate(result, Double.parseDouble(tokens.remove(0)));
        return tokens.isEmpty() || calculate();
    }

    private static Operator convertSymbolToOperator(String symbol) {
        final String conversionTable[] = { "PLUS", "MINUS", "MULTIPLY", "DIVIDE" };
        return Operator.valueOf(conversionTable["+-*/".indexOf(symbol)]);
    }

    public double getValue() {
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}

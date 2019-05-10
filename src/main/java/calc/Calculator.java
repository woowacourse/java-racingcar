package calc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    private final List<String> tokens;
    private double result;

    Calculator(String expression) {
        try {
            tokens = Stream.of(expression.split(" "))
                    .map(x -> x.trim())
                    .filter(x -> !x.equals("") && !x.equals(" "))
                    .collect(Collectors.toList());
            result = Double.parseDouble(tokens.remove(0));
            calculate();
        } catch (IndexOutOfBoundsException | NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean calculate() {
        result = Operation.ofSymbol(tokens.remove(0))
                .apply(result, Double.parseDouble(tokens.remove(0)));
        return tokens.isEmpty() || calculate();
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
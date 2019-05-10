package calc;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    private final Queue<String> tokens;
    private double result;

    Calculator(String expression) {
        try {
            tokens = new LinkedList<>(
                    Stream.of(expression.split(" "))
                    .map(x -> x.trim())
                    .filter(x -> !x.equals("") && !x.equals(" "))
                    .collect(Collectors.toList())
            );
            result = Double.parseDouble(tokens.poll());
            calculate();
        } catch (IndexOutOfBoundsException | NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean calculate() {
        result = Operation.ofSymbol(tokens.poll())
                .apply(result, Double.parseDouble(tokens.poll()));
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
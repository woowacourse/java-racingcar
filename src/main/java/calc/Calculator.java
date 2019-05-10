package calc;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Calculator {
    private final List<String> tokens;
    private double result;

    Calculator(String expression) throws IllegalArgumentException {
        try {
            tokens = Arrays.asList(expression.split(" ")).stream()
                    .map(x -> x.trim())
                    .filter(x -> !x.equals("") && !x.equals(" "))
                    .collect(Collectors.toList());
            result = Double.parseDouble(tokens.remove(0));
            calculate();
        } catch (IndexOutOfBoundsException
                | NoSuchElementException
                | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean calculate() throws NumberFormatException {
        result = Operator.getOperation(tokens.remove(0))
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

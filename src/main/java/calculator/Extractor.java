package calculator;

import java.util.*;

public class Extractor {
    private List<Integer> numbers = new ArrayList<>();
    private List<String> symbols = new ArrayList<>();

    Extractor(List<String> expression) {
        checkConditionsForExtractor(expression);
        for (int i = 0, n = expression.size(); i <n; i += 2) {
            numbers.add(Integer.parseInt(expression.get(i)));
        }
        for (int i = 1, n = expression.size(); i < n; i += 2) {
            symbols.add(expression.get(i));
        }
    }

    public static Extractor instantiateExtractor() {
        try {
            Extractor extractor = new Extractor(new ArrayList<>(Arrays.asList(InputView.askAndReceiveExpression().split(" "))));
            return extractor;
        } catch (Exception e) {
            return instantiateExtractor();
        }
    }

    private static void checkConditionsForExtractor(List<String> expression) {
        if (isSymbolsNotInCorrectOrder(expression) || isNotCalculable(expression)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSymbolsNotInCorrectOrder(List<String> expression) {
        boolean isNotCorrectOrder = false;
        for (int i = 1, n = expression.size(); i < n && !isNotCorrectOrder; i += 2) {
            isNotCorrectOrder = checkCorrectOrder(expression.get(i));
        }
        return isNotCorrectOrder;
    }

    private static boolean checkCorrectOrder(String symbol) {
        if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")) {
            return false;
        }
        return true;
    }

    private static boolean isNotCalculable(List<String> expression) {
        int numberCount = 0;
        int symbolCount = 0;
        int n = expression.size();
        for (int i = 0; i < n; i += 2) {
            numberCount++;
        }
        for (int i = 1; i < n; i += 1 ) {
            symbolCount++;
        }
        if (numberCount + 1 > symbolCount) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Extractor extractor = (Extractor) o;
        return Objects.equals(numbers, extractor.numbers) &&
                Objects.equals(symbols, extractor.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, symbols);
    }
}

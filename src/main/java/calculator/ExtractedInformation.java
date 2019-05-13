package calculator;

import java.util.*;

public class ExtractedInformation {
    private List<Integer> numbers = new ArrayList<>();
    private List<String> symbols = new ArrayList<>();

    ExtractedInformation(List<String> expression) {
        checkConditions(expression);
        for (int i = 0, n = expression.size(); i <n; i += 2) {
            numbers.add(Integer.parseInt(expression.get(i)));
        }
        for (int i = 1, n = expression.size(); i < n; i += 2) {
            symbols.add(expression.get(i));
        }
    }

    public static ExtractedInformation instantiateExtractor() {
        try {
            ExtractedInformation extractedInfo = new ExtractedInformation(new ArrayList<>(Arrays.asList(InputView.askAndReceiveExpression().split(" "))));
            return extractedInfo;
        } catch (Exception e) {
            return instantiateExtractor();
        }
    }

    private static void checkConditions(List<String> expression) {
        if (isSymbolsNotInCorrectOrder(expression) || isNotCalculable(expression) || isZeroDivision(expression)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isZeroDivision(List<String> expression) {
        boolean zeroDivision = false;
        for (int i = 1, n = expression.size(); i < n && !zeroDivision; i++) {
            zeroDivision = checkZeroDivision(expression.get(i), expression.get(i-1));
        }
        return zeroDivision;
    }

    private static boolean checkZeroDivision(String symbol, String number) {
        if (symbol.equals("/") && number.equals("0")) {
            System.out.println("0으로 나눌 수 없습니다!");
            return true;
        }
        return false;
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
        System.out.println("기호가 잘못되었습니다!");
        return true;
    }

    private static boolean isNotCalculable(List<String> expression) {
        int numberCount = 0;
        int symbolCount = 0;
        int n = expression.size();
        for (int i = 0; i < n; i += 2) {
            numberCount++;
        }
        for (int i = 1; i < n; i += 2 ) {
            symbolCount++;
        }
        if (numberCount - symbolCount == 1) {
            return false;
        }
        return true;
    }

    public int getInitialValue() {
        return numbers.get(0);
    }

    public int getSymbolSize() {
        return symbols.size();
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }

    public String getSymbol(int index) {
        return symbols.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtractedInformation extractor = (ExtractedInformation) o;
        return Objects.equals(numbers, extractor.numbers) &&
                Objects.equals(symbols, extractor.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, symbols);
    }
}

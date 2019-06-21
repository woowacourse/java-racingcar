package calculator.model;


import java.util.*;

public class ExtractedInformation {
    private static final String ZERO = "0";
    private static final String SPACE = " ";

    private List<Integer> numbers = new ArrayList<>();
    private List<Operator> symbols = new ArrayList<>();

    public ExtractedInformation(String expression) {
        checkNull(expression);
        List<String> numbersAndSymbols = new ArrayList<>(Arrays.asList(expression.split(SPACE)));
        checkConditions(numbersAndSymbols);
        for (int i = 0, n = numbersAndSymbols.size(); i < n; i += 2) {
            numbers.add(Integer.parseInt(numbersAndSymbols.get(i)));
        }
        for (int i = 1, n = numbersAndSymbols.size(); i < n; i += 2) {
            symbols.add(Operator.from(numbersAndSymbols.get(i)));
        }
    }

    private static void checkNull(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkConditions(List<String> expression) {
        if (isNotCalculable(expression) || isZeroDivision(expression)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isZeroDivision(List<String> expression) {
        boolean zeroDivision = false;
        for (int i = 1, n = expression.size(); i < n - 1 && !zeroDivision; i++) {
            zeroDivision = checkZeroDivision(expression.get(i), expression.get(i + 1));
        }
        return zeroDivision;
    }

    private static boolean checkZeroDivision(String symbol, String number) {
        if (symbol.equals("/") && ZERO.equals(number)) {
            System.out.println("0으로 나눌 수 없습니다!");
            return true;
        }
        return false;
    }

    private static boolean isNotCalculable(List<String> expression) {
        int numberCount = 0;
        int symbolCount = 0;
        int n = expression.size();
        for (int i = 0; i < n; i += 2) {
            numberCount++;
        }
        for (int i = 1; i < n; i += 2) {
            symbolCount++;
        }
        if (numberCount - symbolCount == 1) {
            return false;
        }
        System.out.println("계산 할 수 없는 식입니다!");
        return true;
    }

    public int calculate(int result, int index) {
        return symbols.get(index).calculate(result, numbers.get(index + 1));
    }

    public int getInitialValue() {
        return numbers.get(0);
    }

    public int getCalculatingRounds() {
        return symbols.size();
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

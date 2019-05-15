package calculator;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class StringCalculator {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = " ";
    private static final String STRING_INPUT_MESSAGE
            = "사칙연산 공식을 입력해 주십시오 :";
    private int result;

    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();
        System.out.println(calc.run());
    }

    public int run() {
        String formula = inputFormula();
        String[] inputData = formula.split(DELIMITER);
        result = calculate(inputData);
        return result;
    }

    private String inputFormula() {
        System.out.println(STRING_INPUT_MESSAGE);
        return SCANNER.nextLine();
    }

    public int calculate(String[] formula) {
        int result = Integer.parseInt(formula[0]);

        for (int i = 1, len = formula.length; i < len; i += 2) {
            int value = Integer.parseInt(formula[i + 1]);
            Operation op = Operation.fromString(formula[i]).orElseThrow();
            result = op.apply(result, value);
        }

        return result;
    }

    @Override
    public String toString() {
        return Integer.toString(this.result);
    }

    // "이펙티브 자바 [3판]"(인사이트, 2018) p. 214~216의 코드를 가져옴.
    public enum Operation {
        PLUS("+") {
            public int apply(int x, int y) { return x + y; }
        },
        MINUS("-") {
            public int apply(int x, int y) { return x - y; }
        },
        TIMES("*") {
            public int apply(int x, int y) { return x * y; }
        },
        DIVIDE("/") {
            public int apply(int x, int y) { return x / y; }
        };

        private static final Map<String, Operation> stringToEnum
                = Stream.of(values()).collect(toMap(Object::toString, e -> e));
        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public static Optional<Operation> fromString(String symbol) {
            return Optional.ofNullable(stringToEnum.get(symbol));
        }

        public abstract int apply(int x, int y);

        @Override
        public String toString() {
            return symbol;
        }
    }
}
package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    List<String> getSplit(String inputString) {
        List<String> row = Arrays.stream(inputString.split(" ")).collect(Collectors.toList());

        if (row.size() == 0) {
            throw new IllegalArgumentException("데이터가 잘못되었습니다!");
        }
        return row;
    }

    int calculateAll(String inputString) {
        int result = 0;
        String operator = null;
        List<String> calculationFormula = getSplit(inputString);

        for (String numberOrOperator : calculationFormula) {
            if (isOperator(numberOrOperator)) {
                operator = numberOrOperator;
                continue;
            }

            if (operator == null) {
                result += Integer.valueOf(numberOrOperator);
                continue;
            }

            result = operate(result, operator, Integer.valueOf(numberOrOperator));
        }
        return result;
    }

    boolean isOperator(String operator) {
        return (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
    }

    int operate(int previousResult, String operator, int number) {
        if (operator.equals("+")) {
            return previousResult + number;
        }
        if (operator.equals("-")) {
            return previousResult - number;
        }
        if (operator.equals("*")) {
            return previousResult * number;
        }
        if (operator.equals("/")) {
            return previousResult / number;
        }
        throw new IllegalArgumentException("잘못된 형식의 연산자입니다!");
    }
}

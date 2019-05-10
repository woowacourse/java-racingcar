package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private Operator operation;

    int calculateAll(String calculateSentence) {
        int result = 0;
        List<String> calculationFormula = getSplit(calculateSentence);

        for (String numberOrOperator : calculationFormula) {
            result = getResult(result, numberOrOperator);
        }
        return result;
    }

    private List<String> getSplit(String calculateSentence) {
        List<String> row = Arrays.asList(calculateSentence.split(" "));

        if (row.isEmpty()) {
            throw new IllegalArgumentException("데이터가 잘못되었습니다!");
        }
        checkInteger(row);
        checkOperator(row);
        return row;
    }

    private void checkInteger(List<String> row) throws NumberFormatException {
        for (int i = 0; i < row.size(); i += 2) {
            Integer.valueOf(row.get(i));
        }
    }

    private void checkOperator(List<String> row) {
        for (int i = 1; i < row.size(); i += 2) {
            if (!Operator.isOperator(row.get(i))) {
                throw new IllegalArgumentException("잘못된 연산기호를 입력하셨습니다!");
            }
        }
    }

    private int getResult(int result, String numberOrOperator) {
        if (Operator.isOperator(numberOrOperator)) {
            operation = Operator.findOperator(numberOrOperator);
            return result;
        }

        if (operation == null) {
            return result + Integer.valueOf(numberOrOperator);
        }

        return operation.applyAsInt(result, Integer.valueOf(numberOrOperator));
    }
}

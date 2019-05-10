package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private Operator operation;

    int calculateAll(String inputString) {
        int result = 0;
        List<String> calculationFormula = getSplit(inputString);

        for (String numberOrOperator : calculationFormula) {
            result = getResult(result, numberOrOperator);
        }
        return result;
    }

    private List<String> getSplit(String inputString) {
        List<String> row = Arrays.stream(inputString.split(" ")).collect(Collectors.toList());

        if (row.size() == 0) {
            throw new IllegalArgumentException("데이터가 잘못되었습니다!");
        }
        return row;
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

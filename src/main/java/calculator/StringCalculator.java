package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    List<String> getSplit(String inputString) {
        List<String> row = Arrays.stream(inputString.split(" "))
                .collect(Collectors.toList());

        if (row.isEmpty()) {
            throw new IllegalArgumentException("데이터가 잘못되었습니다!");
        }
        return row;
    }

    int calculateAll(String inputString) {
        int result = 0;
        Operator operation = null;
        List<String> calculationFormula = getSplit(inputString);

        for (String numberOrOperator : calculationFormula) {

            if (Operator.isOperator(numberOrOperator)) {
                operation = Operator.valueof(numberOrOperator);
                continue;
            }

            if (operation == null) {
                result += Integer.valueOf(numberOrOperator);
                continue;
            }

            result = operation.applyAsInt(result, Integer.valueOf(numberOrOperator));
        }
        return result;
    }
}

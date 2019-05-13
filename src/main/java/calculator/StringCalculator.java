package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final int FIRST_ELEMENT_IDX = 0;

    int calculateAll(String inputString) {
        List<String> elementsOfFormula = getSplit(inputString);
        Operator operator = null;
        int result = 0;

        result += Integer.valueOf(elementsOfFormula.remove(FIRST_ELEMENT_IDX));
        for (String numberOrOperator : elementsOfFormula) {
            if (Operator.isOperator(numberOrOperator)) {
                operator = Operator.of(numberOrOperator);
                continue;
            }

           result = operator.applyAsInt(result, Integer.valueOf(numberOrOperator));
        }
        return result;
    }

    List<String> getSplit(String inputString) {
        List<String> elementsOfFormula = Arrays.stream(inputString.split(" "))
                .collect(Collectors.toList());

        if (elementsOfFormula.isEmpty()) {
            throw new IllegalArgumentException("데이터가 잘못되었습니다!");
        }
        return elementsOfFormula;
    }
}

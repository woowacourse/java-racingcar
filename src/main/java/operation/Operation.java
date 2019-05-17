package operation;

import static operation.OperationValidator.checkDivideByZero;
import static operation.OperationValidator.isNumber;

public class Operation {

    double calculate(String predictor) {
        String[] predictorIndex = predictor.trim().split(" ");
        double result = isNumber(predictorIndex[0]);

        for (int i = 1; i < predictorIndex.length; i += 2) {
            double number = isNumber(predictorIndex[i + 1]);
            String operator = checkDivideByZero(predictorIndex[i], number);
            result = Operator.doCalculator(operator, result, number);
        }

        return result;
    }

}

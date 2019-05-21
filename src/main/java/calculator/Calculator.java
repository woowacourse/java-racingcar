package calculator;

public class Calculator {


    public int calculateSingleExpression(int leftOperand, String operator, String rightOperandStr) {
        int rightOperand = Integer.parseInt(rightOperandStr);
        return Operator.getOperatorByCode(operator)
                .apply(leftOperand, rightOperand);
    }

    public int calculateMultiExpression(String[] strings) {
        int result = Integer.parseInt(strings[0]);

        if (strings.length == 1)
            return result;

        for (int i = 1; i < strings.length; ) {
            result = calculateSingleExpression(result, strings[i], strings[i + 1]);
            i = i + 2;
        }
        return result;
    }

    public int calculateInput(String input) {
        String[] tokens = input.split(" ");
        return calculateMultiExpression(tokens);
    }
}

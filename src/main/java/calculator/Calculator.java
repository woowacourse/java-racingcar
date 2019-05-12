package calculator;

import java.util.function.BinaryOperator;

class Calculator {
    int calculateSingleExpression(int leftOperand, String operator, int rightOperand) {
        return Operator.getOperator(operator).calculate(leftOperand, rightOperand);
    }

    int calculateMultiExpression(String[] strings) {
        int result = Integer.parseInt(strings[0]);

        if (strings.length == 1)
            return result;
        for (int i = 1; i < strings.length; ) {
            result = calculateSingleExpression(result, strings[i],
                    Integer.parseInt(strings[i + 1]));
            i = i + 2;
        }
        return result;
    }

    int calculate() throws Exception {
        String[] input = InputHandler.getInput().split(" ");
        if (!InputHandler.canCalculate(input))
            throw new Exception("계산 가능한 형식이 아닙니다.");
        try {
            int result = calculateMultiExpression(input);
            System.out.println("계산 결과 : " + result);
            return result;
        } catch (ArithmeticException ae) {
            throw new Exception("0으로 나눌 수 없습니다.");
        }
    }

    public enum Operator {
        ADD("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
        SUB("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
        MUL("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
        DIV("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

        private String operator;
        private BinaryOperator<Integer> calcFunction;

        Operator(String operator, BinaryOperator<Integer> calcFunction) {
            this.operator = operator;
            this.calcFunction = calcFunction;
        }

        private boolean matchOperator(String operator) {
            return operator.equals(this.operator);
        }

        static Operator getOperator(String operator) {
            for (Operator op : Operator.values()) {
                if (op.matchOperator(operator))
                    return op;
            }
            return null;
        }

        int calculate(int leftOperand, int rightOperand) {
            return calcFunction.apply(leftOperand, rightOperand);
        }
    }
}

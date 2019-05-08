public class Calculator {

    public int mult(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }


    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {

        return num1 - num2;
    }

    public int calculateSingleExpression(int leftOperand, String operator, String rightOperandStr) {
        int rightOperand = Integer.parseInt(rightOperandStr);

        if (operator.equals("+"))
            return add(leftOperand, rightOperand);
        if (operator.equals("-"))
            return subtract(leftOperand, rightOperand);
        if (operator.equals("*"))
            return mult(leftOperand, rightOperand);
        return divide(leftOperand, rightOperand);
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

    public int calculate() throws Exception {
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

    public static void main(String[] args) {

    }
}

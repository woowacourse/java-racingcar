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

    public int calculateString(int leftOperand, String operator, String rightOperandStr) {
        int rightOperand = Integer.parseInt(rightOperandStr);

        if(operator.equals("+"))
            return add(leftOperand, rightOperand);
        if(operator.equals("-"))
            return subtract(leftOperand, rightOperand);
        if(operator.equals("*"))
            return mult(leftOperand, rightOperand);
        return divide(leftOperand, rightOperand);
    }

    public static void main(String[] args) {

    }
}

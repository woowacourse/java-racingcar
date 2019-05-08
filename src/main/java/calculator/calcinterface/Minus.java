package calculator.calcinterface;

public class Minus implements Operation {
    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 - operand2;
    }
}

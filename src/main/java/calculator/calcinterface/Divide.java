package calculator.calcinterface;

public class Divide implements Operation {
    @Override
    public int calculate(int operand1, int operand2) throws ArithmeticException{
        return operand1 / operand2;
    }
}

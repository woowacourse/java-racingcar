package calculator.calcinterface;

public class CalculatorMain {
    public static void main(String[] args) {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        CalculatorLine calculatorLine = new CalculatorLine();

        int result = calculatorLine.calculateFormula(
                userInterfaceView.inputFormula()
        );

        userInterfaceView.outputResult(result);
    }
}

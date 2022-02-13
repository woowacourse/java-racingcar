package calculator;

import java.io.IOException;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class Application {

    public static void main(String[] args) throws IOException {
        CalculatorController calculatorController = CalculatorController.getCalculatorController();
        calculatorController.runCalculator(InputView.askInput());
    }
}

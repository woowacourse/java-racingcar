package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        CalculatorController calculatorController = CalculatorController.getCalculatorController();
        calculatorController.runCalculator(InputView.askInput());
    }
}

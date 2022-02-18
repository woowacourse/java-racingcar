package calculator;

import java.io.IOException;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class Application {

    public static void main(String[] args) throws IOException {
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.runCalculator(InputView.askInput());
    }
}

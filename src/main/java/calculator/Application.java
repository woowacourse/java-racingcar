package calculator;

import calculator.domain.CalculatorController;

public class Application {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController();
        controller.run();
    }
}

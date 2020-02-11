package calculator.domain;

import calculator.domain.StringCalculator;
import calculator.io.UserInput;

public class CalculatorController {
    public void run() {
        try {
            StringCalculator.run(UserInput.getInput());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {

    public static void main(String[] args) {
        try {
            proceed();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            proceed();
        }
    }

    private static void proceed() {
        String input = InputView.takeUserInput();
        OutputView.showResult(StringCalculator.calculate(input));
    }
}

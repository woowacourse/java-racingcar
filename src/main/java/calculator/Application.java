package calculator;

import calculator.domain.Delimiter;
import calculator.domain.Numbers;
import calculator.domain.StringAdditionCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.receiveInput();
        String input = InputView.receiveInput();
        Delimiter delimiter = new Delimiter(input);

        if (Delimiter.START_CHARACTER
                .equals(input.substring(Delimiter.FIRST_INDEX, Delimiter.START_INDEX))) {
            input = InputView.receiveInput();
        }

        Numbers numbers = new Numbers(input, delimiter.getDelimiter());

        StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();
        int result = stringAdditionCalculator.calculate(numbers.getNumbers());

        OutputView.showResult(result);
    }
}

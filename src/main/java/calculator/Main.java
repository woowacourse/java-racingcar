package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class Main {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        String input = InputView.getValues();
        try {
            int answer = stringCalculator.calculate(input);
            System.out.println("답은 " + answer + "입니다");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

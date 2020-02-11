package calculator;

import calculator.domain.StringCalculator;
import calculator.view.UserInput;

public class Application {
    public static void main(String[] args) {
        runCalculator();
    }

    private static void runCalculator() {
        final String INPUTMESSAGE = "수식을 입력하세요: ";
        final String SUMIS = "총합은 %d입니다.";
        try {
            System.out.println(INPUTMESSAGE);
            System.out.println(String.format(SUMIS, StringCalculator.splitAndSum(UserInput.inputExpression())));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            runCalculator();
        }
    }
}

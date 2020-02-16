package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculator {
    public static final String ERR_NUMBER_FORMAT_EXCEPTION = "양수의 정수만 입력할 수 있습니다.";

    public static void run() {
        String value = InputView.inputValue();
        String[] numbers = inputValue(value);
        int result = getCalculateResult(numbers);

        OutputView.printResult(result);
    }

    private static String[] inputValue(String value) {
        return Calculator.splitString(value);
    }

    private static int getCalculateResult(String[] numbers) {
        try {
            return Calculator.calculate(numbers);
        } catch (NumberFormatException e) {
            System.err.println(ERR_NUMBER_FORMAT_EXCEPTION);
            run();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            run();
        }
        return 0;
    }
}

package calculator;

public class StringCalculator {
    double calculateAll(String[] inputs) {
        if (inputs.length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        double result = Double.parseDouble(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            result = Calculator.selectCalculator(inputs[i])
                    .calculate(result, Double.parseDouble(inputs[i + 1]));
        }
        return result;
    }
}

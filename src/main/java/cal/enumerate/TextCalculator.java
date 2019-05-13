package cal.enumerate;

public class TextCalculator {
    public static double calculate(String inputText) {
        String input[] = inputText.split(" ");
        double result = Double.valueOf(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            String operator = input[i];
            double number = Double.valueOf(input[i + 1]);
            result = calculate(operator, result, number);
        }
        return result;
    }

    private static double calculate(String operator, double result, double number) {
        return Calculator.calculate(operator, result, number);
    }
}

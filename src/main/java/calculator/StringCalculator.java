package calculator;

public class StringCalculator {
    private static final String BLANK = " ";

    public int calculate(String input) {
        String[] values = splitWithBlank(input);
        String operator = null;
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i++) {
            if (isInteger(values[i])) {
                int nextValue = Integer.parseInt(values[i]);
                result = unitCalculate(result, operator, nextValue);
                continue;
            }
            operator = values[i];
        }
        return result;
    }

    private String[] splitWithBlank(String value) {
        return value.split(BLANK);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            return false;
        }
    }

    private int unitCalculate(int result, String operator, int nextValue) {
        if (operator.equals("+")) {
            return (result + nextValue);
        }

        if (operator.equals("-")) {
            return (result - nextValue);
        }

        if (operator.equals("*")) {
            return (result * nextValue);
        }

        if (operator.equals("/")) {
            return (result / nextValue);
        }

        throw new RuntimeException("잘못된 operator를 입력");
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        String input = InputView.getValues();
        int answer = stringCalculator.calculate(input);
        System.out.println("답은 " + answer + "입니다");
    }
}

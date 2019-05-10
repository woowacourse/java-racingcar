package textCalculaotr;

public class TextCalculator {
    public int execute(String[] inputText) {
        int result = parseStringToInt(inputText[0]);

        for (int i = 1; i < inputText.length ; i += 2) {
            result = calculate(result, inputText[i], parseStringToInt(inputText[i + 1]));
        }

        return result;
    }

    private int parseStringToInt(String strValue) {
        return Integer.parseInt(strValue);
    }

    private int calculate(int result, String operator, int nextValue) {
        if (operator.equals("+")) {
            return Calculator.add(result, nextValue);
        }

        if (operator.equals("-")) {
            return Calculator.subtract(result, nextValue);
        }

        if (operator.equals("*")) {
            return Calculator.multiply(result, nextValue);
        }

        if (operator.equals("/")) {
            return Calculator.division(result, nextValue);
        }

        return 0;
    }
}

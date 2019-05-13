package stringcal;

public class StringCalculator {
    public int calculate(String inputString) {
        return arrayCalculate(inputString.split(" "));
    }

    public int minCalculate(int a, int b, String op) {
        if (op == "+") {
            return a + b;
        }

        if (op == "-") {
            return a - b;
        }

        if (op == "/") {
            return a / b;
        }

        if (op == "*") {
            return a * b;
        }
        throw new IllegalArgumentException();
    }

    public int arrayCalculate(String[] parsedStrings) {
        int result;
        String op;

        result = Integer.parseInt(parsedStrings[0]);
        for (int i = 1; i < parsedStrings.length; i += 2) {
            op = parsedStrings[i];
            result = minCalculate(result, Integer.parseInt(parsedStrings[i + 1]), op);
        }
        return result;
    }
}

package operation;

import java.util.regex.Pattern;

public class Operation {

    public int calculate(String index) {
        String[] valueArr = index.split(" ");
        int result = Integer.parseInt(valueArr[0]);

        for (int i = 0; i < valueArr.length; i++) {
            result = getResult(valueArr, result, i);
        }

        return result;
    }

    private int getResult(String[] valueArr, int result, int i) {
        String patterns = "^[0-9]$";

        if (!Pattern.matches(patterns, valueArr[i])) {
            result = operate(valueArr, result, i);

        }
        return result;
    }

    private int operate(String[] valueArr, int result, int i) {
        if (valueArr[i].equals("+")) {
            result += Integer.parseInt(valueArr[i + 1]);
        }
        if (valueArr[i].equals("-")) {
            result -= Integer.parseInt(valueArr[i + 1]);
        }
        if (valueArr[i].equals("*")) {
            result *= Integer.parseInt(valueArr[i + 1]);
        }
        if (valueArr[i].equals("/")) {
            result /= Integer.parseInt(valueArr[i + 1]);
        }
        return result;
    }
}

package textCalculaotr;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Operators> map = new HashMap<>();
        Operators[] operators = Operators.values();

        for (Operators operator1 : operators) {
            map.put(operator1.getOperator(), operator1);
        }

        if (map.get(operator) == null) {
            return 0;
        }

        return map.get(operator).result(result, nextValue);
    }
}
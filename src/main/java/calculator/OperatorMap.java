package calculator;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {
    private Map<String, Operator> functionMap = new HashMap<>();

    OperatorMap() {
        functionMap.put("+", Operator.PLUS);
        functionMap.put("-", Operator.MINUS);
        functionMap.put("/", Operator.DIVIDE);
        functionMap.put("*", Operator.MULTIPLY);
    }
}

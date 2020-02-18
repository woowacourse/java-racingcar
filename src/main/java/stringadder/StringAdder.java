package stringadder;

import java.util.Collections;
import java.util.List;

public class StringAdder {
    private StringAdder() {
    }

    public static int add(String value) {
        try {
            Input input = new Input(value);
            List<Integer> values = input.getExpression();
            validateValues(values);
            return values.stream()
                    .reduce(0, Integer::sum);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    private static void validateValues(List<Integer> values) {
        if (Collections.min(values) < 0) {
            throw new RuntimeException("음수는 입력하실 수 없습니다.");
        }
    }
}
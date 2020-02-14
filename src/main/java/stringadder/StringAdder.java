package stringadder;

import java.util.Collections;
import java.util.List;

public class StringAdder {
    public static final String NEGATIVE_INPUT_ERROR = "음수는 입력하실 수 없습니다.";

    private StringAdder() {
    }

    public static int add(String value) {
        try {
            Input input = new Input(value);
            List<Integer> values = input.splitInput();
            validateValues(values);
            return values.stream()
                    .reduce(0, Integer::sum);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    private static void validateValues(List<Integer> values) {
        if (Collections.min(values) < 0) {
            throw new RuntimeException(NEGATIVE_INPUT_ERROR);
        }
    }
}
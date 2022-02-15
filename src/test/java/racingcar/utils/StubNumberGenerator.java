package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StubNumberGenerator implements NumberGenerator{

    private final List<Integer> numbers;
    private int index;

    public StubNumberGenerator() {
        numbers = new ArrayList<>();
        index = 0;
    }

    public void prepareStubNumbers(int count, int ... values) {
        checkValuesLengthSameAsCount(count, values);
        Arrays.stream(values)
                .forEach(value -> {
                    checkValueRange(value);
                    numbers.add(value);
                });
    }

    private void checkValuesLengthSameAsCount(int count, int[] values) {
        if (values.length != count) {
            throw new AssertionError("put as many values as the count");
        }
    }

    private void checkValueRange(int value) {
        if (value < 0 || value >= 10) {
            throw new AssertionError("put value that is between 0 and 9");
        }
    }

    @Override
    public int generate() {
        if (index >= numbers.size()) {
            throw new AssertionError("index out of bounds");
        }
        return numbers.get(index++);
    }
}

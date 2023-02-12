package domain;

import java.util.List;

public class TestRandomGenerator implements RandomGenerator {

    private final List<Integer> numbers = List.of(3, 5, 7);
    private int index = 0;

    public int generate() {
        if (index < numbers.size()) {
            return numbers.get(index++);
        }

        return 0;
    }
}

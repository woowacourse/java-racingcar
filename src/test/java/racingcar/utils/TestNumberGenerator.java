package racingcar.utils;

import java.util.List;
import racingcar.domain.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public TestNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}

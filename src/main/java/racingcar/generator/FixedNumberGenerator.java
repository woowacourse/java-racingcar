package racingcar.generator;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;
    public FixedNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate(int size) {
        return this.numbers;
    }
}

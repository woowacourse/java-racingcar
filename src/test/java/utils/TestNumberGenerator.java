package utils;

import domain.NumberGenerator;
import java.util.List;

public class TestNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}

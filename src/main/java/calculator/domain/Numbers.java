package calculator.domain;

import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int calculateSum() {
        return this.numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }
}

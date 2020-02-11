package calculator.domain;

import java.util.List;

public class StringAdditionCalculator {
    public int calculate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

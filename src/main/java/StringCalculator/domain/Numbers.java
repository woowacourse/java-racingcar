package stringcalculator.domain;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(String[] inputs) {
         this. numbers = Arrays.stream(inputs)
                 .map(Number::new)
                 .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(number -> number.getNumber())
                .sum();
    }
}

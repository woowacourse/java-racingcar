package calculator.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final List<String> numbers;

    public Calculator(List<String> numbers) {
        this.numbers = replaceBlankNumberZero(new ArrayList<>(numbers));
    }

    private List<String> replaceBlankNumberZero(List<String> numbers) {
        return numbers.stream()
                .filter(number -> !StringUtils.isBlank(number))
                .collect(Collectors.toList());
    }

    public int makeSumOfNumbers() {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}

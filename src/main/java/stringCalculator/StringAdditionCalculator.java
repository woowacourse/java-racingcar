package stringCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringAdditionCalculator {
    public static int sum(List<Integer> operands) {
        return operands.stream()
                .mapToInt((t) -> t)
                .sum();
    }
}

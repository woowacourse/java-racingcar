package stringCalculator;

import java.util.List;

public class StringAdditionCalculator {
    public static int sum(List<Integer> operands) {
        return operands.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

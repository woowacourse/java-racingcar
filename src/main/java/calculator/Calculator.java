package calculator;

import java.util.List;

public class Calculator {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수 계산 불가능";

    public int sum(List<Integer> nums) {
        for (Integer num : nums) {
            validatePositive(num);
        }
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    private void validatePositive(Integer num) {
        if (num < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}

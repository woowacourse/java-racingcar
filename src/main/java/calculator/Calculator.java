package calculator;

import java.util.List;

public class Calculator {

    public int sum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }
}

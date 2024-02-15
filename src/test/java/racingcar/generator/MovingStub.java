package racingcar.generator;

import java.util.List;

public class MovingStub implements IntegerGenerator {

    private final List<Integer> nums;
    private int index = 0;

    public MovingStub(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public int generate() {
        int num = nums.get(index);
        index++;
        if (index >= nums.size()) {
            index = 0;
        }
        return num;
    }
}

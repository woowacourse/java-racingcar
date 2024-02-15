package racingcar.generator;

import java.util.List;

public class MovingStub implements NumberGenerator {

    private final List<Integer> numbers;
    private int index = 0;

    public MovingStub(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        int num = numbers.get(index);
        index++;
        if (index >= numbers.size()) {
            index = 0;
        }
        return num;
    }
}

package model.intgenerator;

import java.util.List;

public class SequenceIntGenerator implements IntGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public SequenceIntGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int pickNumber() {
        int number = numbers.get(index);
        index++;
        if (index >= numbers.size()) {
            index = 0;
        }
        return number;
    }
}

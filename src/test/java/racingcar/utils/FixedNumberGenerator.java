package racingcar.utils;

public class FixedNumberGenerator implements NumberGenerator {
    private final int[] numbers;
    private int index;

    public FixedNumberGenerator(int[] numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public int generateNumber() {
        return numbers[index++];
    }
}

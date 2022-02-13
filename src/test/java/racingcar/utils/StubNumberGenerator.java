package racingcar.utils;

public class StubNumberGenerator implements NumberGenerator{

    private static final int NOT_MOVABLE = 3;
    private static final int MOVABLE = 4;

    private int[] numbers = new int[]{NOT_MOVABLE, MOVABLE, MOVABLE, NOT_MOVABLE};
    private int sequence = 0;

    @Override
    public int generate() {
        if (sequence == 4) {
            sequence = 0;
        }
        return numbers[sequence++];
    }
}

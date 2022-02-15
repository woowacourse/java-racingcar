package racingcar.util;

public class RandomGeneratorMock implements RandomGeneratable {
    private static final int[] randomNumbers = {2, 3, 4, 5};
    private int sequenceCursor = 0;

    public int generateNumber(int min, int max) {
        int currentNumber = randomNumbers[sequenceCursor % randomNumbers.length];
        sequenceCursor++;

        return currentNumber;
    }
}

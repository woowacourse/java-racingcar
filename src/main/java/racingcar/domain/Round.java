package racingcar.domain;

public class Round {

    private int count;

    private Round(int count) {
        isPositive(count);
        this.count = count;
    }

    public static Round create(int inputNumber) {
        return new Round(inputNumber);
    }

    public static void isPositive(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("Round must be positive");
        }
    }

    public void next() {
        count--;
    }

    public boolean isEnd() {
        return count <= 0;
    }
}

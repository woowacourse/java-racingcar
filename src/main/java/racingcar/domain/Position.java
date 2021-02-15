package racingcar.domain;

public class Position {

    private static final int INITIAL_VALUE = 0;

    private int value;

    Position() {
        this.value = INITIAL_VALUE;
    }

    public void progressOneTurn() {
        this.value++;
    }

    public boolean isSameValue(int targetValue) {
        return this.value == targetValue;
    }

    public int getValue() {
        return this.value;
    }
}

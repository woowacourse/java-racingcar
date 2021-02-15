package racingcar.domain;

public class Position {
    private static final int INITIAL_VALUE = 0;

    private int value;

    Position() {
        this.value = INITIAL_VALUE;
    }

    public void progressOneTime() {
        this.value++;
    }

    public boolean isSameValue(int targetValue) {
        if (this.value == targetValue) {
            return true;
        }
        return false;
    }

    public int getValue() {
        return this.value;
    }
}

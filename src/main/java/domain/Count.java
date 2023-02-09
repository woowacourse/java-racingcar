package domain;

public class Count {

    private static final int PLAYABLE_LOWER_BOUND = 1;

    private int value;

    public Count(final int value) {
        this.value = value;
    }

    public void decrease() {
        value--;
    }

    public boolean isPlayable() {
        return value >= PLAYABLE_LOWER_BOUND;
    }

    public int getValue() {
        return value;
    }
}

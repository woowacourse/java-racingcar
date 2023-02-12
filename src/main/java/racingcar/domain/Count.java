package racingcar.domain;

public class Count {

    private static final int PLAYABLE_LOWER_BOUND = 1;

    private int value;

    Count(final int value) {
        this.value = value;
    }

    public void decrease() {
        value--;
    }

    public boolean isPlayable() {
        return PLAYABLE_LOWER_BOUND <= value;
    }
}

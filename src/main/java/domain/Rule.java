package domain;

public enum Rule {

    MOVE(1),
    STOP(0);

    static final int BOUND_RULE_NUMBER = 10;
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MAX_MOVE_NUMBER = 9;
    private static final int MIN_STOP_NUMBER = 0;

    private int augmenter;

    private Rule(int augmenter) {
        this.augmenter = augmenter;
    }

    public int getAugmenter() {
        return augmenter;
    }

    public static Rule isMove(int number) {
        if (number > MAX_MOVE_NUMBER || number < MIN_STOP_NUMBER) {
            throw new IllegalArgumentException("잘못된 randomNumber");
        }
        if (number >= MIN_MOVE_NUMBER) {
            return MOVE;
        }
        return STOP;
    }

}

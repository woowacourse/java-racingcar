package racing.domain;

public class Rule {
    private static final int RAND_INT_UPPER_BOUND = 10;
    private static final int CRITERIA_OF_GO_STOP = 4;

    private final int random = (int) (Math.random() * RAND_INT_UPPER_BOUND);

    public boolean goOrStop() {
        return this.random >= CRITERIA_OF_GO_STOP;
    }
}

package racingCar.domain;

public class Player {
    private static final int THREE_FOR_DECIDING = 3;
    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private int position;

    public Player(Name name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    /**
     * @return position after action
     */
    public int goOrWait(Decider decider) {
        if (decider.isBiggerThan(THREE_FOR_DECIDING)) {
            goOneStep();
        }

        return position;
    }

    private void goOneStep() {
        position += 1;
    }

    public boolean isWinner(int max) {
        return position == max;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

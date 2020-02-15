package racingCar.domain;

import java.util.stream.IntStream;

public class Player {
    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private int position;

    public Player(Name name) {
        this(name, DEFAULT_POSITION);
    }

    /**
     * use only for test
     */
    public Player(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    /**
     * @return position after action
     */
    public int goOrWait(boolean shouldGo) {
        if (shouldGo) {
            goOneStep();
        }

        return position;
    }

    private void goOneStep() {
        position += 1;
    }

    public static int compare(Player a, Player b) {
        return a.position - b.position;
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

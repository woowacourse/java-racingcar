package racingCar.domain;

import java.util.stream.IntStream;

public class Player {
    private static final String COLON_WRAPPED_WITH_SPACE = " : ";
    private static final String HYPHEN = "-";
    private static final int DEFAULT_POSITION = 0;

    private Name name;
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

    /**
     * 예시) pobi : ---
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name.getString());
        stringBuilder.append(COLON_WRAPPED_WITH_SPACE);
        IntStream.range(0, position)
                .forEach((t) -> stringBuilder.append(HYPHEN));
        return stringBuilder.toString();
    }

    public static int compare(Player a, Player b) {
        return a.position - b.position;
    }

    public boolean isWinner(int max) {
        return position == max;
    }

    public String getName() {
        return name.getString();
    }

    public int getPosition() {
        return position;
    }
}

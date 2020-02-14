package racingCar.domain;

import java.util.stream.IntStream;

public class Player {
    private static final String COLON_WRAPPED_WITH_SPACE = " : ";
    private static final String HYPHEN = "-";
    private static final int DEFAULT_POSITION = 0;

    private PlayerName name;
    private int position;

    Player(PlayerName name) {
        this(name, DEFAULT_POSITION);
    }

    private Player(PlayerName name, int position) {
        this.name = name;
        this.position = position;
    }

    void play(boolean shouldGo) {
        if (shouldGo) {
            goOneStep();
        }
    }

    private void goOneStep() {
        position += 1;
    }

    /**
     * 예시) pobi : ---
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name.toString());
        stringBuilder.append(COLON_WRAPPED_WITH_SPACE);
        IntStream.range(0, position)
                .forEach((t) -> stringBuilder.append(HYPHEN));
        return stringBuilder.toString();
    }

    static int compare(Player a, Player b) {
        return a.position - b.position;
    }

    boolean isWinner(int max) {
        return position == max;
    }

    PlayerName getName() {
        return name;
    }

    int getPosition() {
        return position;
    }
}

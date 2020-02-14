package racingCar.domain;

import java.util.stream.IntStream;

public class Player {
    private static final String COLON_WRAPPED_WITH_SPACE = " : ";
    private static final String HYPHEN = "-";

    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void play(boolean shouldGo) {
        if(shouldGo) {
            goOneStep();
        }
    }

    public void goOneStep() {
        position += 1;
    }

    /**
     * 예시) pobi : ---
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name);
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
        return name;
    }

    public int getPosition() {
        return position;
    }
}

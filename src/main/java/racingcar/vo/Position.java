package racingcar.vo;

public class Position implements Comparable<Position> {

    private static final int INIT_POSITION = 0;
    private static final String POSITION_BAR = "-";

    private int position;

    public Position() {
        position = INIT_POSITION;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_BAR);
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Position position) {
        return this.position - position.position;
    }
}

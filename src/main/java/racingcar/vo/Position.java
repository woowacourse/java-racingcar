package racingcar.vo;

public class Position implements Comparable<Position> {

    private static final int INIT_POSITION = 0;
    private static final String POSITION_BAR = "-";
    private static final int MOVE_ONE_TIME = 1;

    private final int position;

    public Position() {
        this.position = INIT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public Position increase() {
        return new Position(position + MOVE_ONE_TIME);
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

    public int getPosition() {
        return position;
    }
}

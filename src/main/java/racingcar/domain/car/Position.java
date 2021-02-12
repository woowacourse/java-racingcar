package racingcar.domain.car;

public class Position {
    private static final int POSITION_MIN = 0;
    private static final Position ZERO_POSITION = new Position(0);

    private final int position;

    private Position(final int position) {
        validate(position);
        this.position = position;
    }

    private static void validate(final int position) {
        if (position < POSITION_MIN) {
            throw new IllegalArgumentException("존재할 수 없는 위치입니다.");
        }
    }

    public static Position valueOf(final int position) {
        if (position == 0) {
            return ZERO_POSITION;
        }
        return new Position(position);
    }

    public Position next() {
        return valueOf(position + 1);
    }

    public int getPosition() {
        return position;
    }
}

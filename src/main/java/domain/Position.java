package domain;

public class Position {

    private static final String ERROR_OF_RANGE = "[ERROR] 자동차의 위치는 음수가 될 수 없습니다.";

    private Integer position;

    private Position(Integer position) {
        validate(position);
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ERROR_OF_RANGE);
        }
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        position++;
    }
}

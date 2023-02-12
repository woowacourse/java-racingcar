package domain;

public class Position {

    private static final String POSITION_CANNOT_BE_NEGATIVE = "[ERROR] 자동차의 위치 값은 음수일 수 없습니다.";

    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        validatePositionIsNotNegative(position);
    }

    private void validatePositionIsNotNegative(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(POSITION_CANNOT_BE_NEGATIVE);
        }
    }

    public void moveForward() {
        position++;
    }

    public int get() {
        return position;
    }
}

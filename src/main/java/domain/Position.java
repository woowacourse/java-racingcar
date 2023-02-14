package domain;

import exception.PositionInvalidException;

public class Position {

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
            throw new PositionInvalidException();
        }
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}

package model.wrapper;

public class Position implements Comparable<Position> {

    private static final int MOVABLE_INCLUSIVE_VALUE = 4;

    private int position = 0;

    public void move(int movableNumber) {
        if (isMovable(movableNumber)) {
            position++;
        }
    }

    private boolean isMovable(int movableNumber) {
        return movableNumber >= MOVABLE_INCLUSIVE_VALUE;
    }

    public boolean isSamePosition(Position otherPosition) {
        return this.position == otherPosition.position;
    }

    @Override
    public int compareTo(Position otherPosition) {
        return this.position - otherPosition.position;
    }

    public int getPosition() {
        return position;
    }
}

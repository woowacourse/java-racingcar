package racingcar.domain;

public class Position {
    public static final String UNIT_OF_POSITION = "-";
    public static final int UNIT_OF_MOVE = 1;

    private int position;

    public Position() {
        this.position = 0;
    }

    public void moveForward() {
        position += UNIT_OF_MOVE;
    }

    public boolean isSmallerThan(int winnerPosition) {
        return position < winnerPosition;
    }

    public boolean isBiggerThan(int winnerPosition) {
        return position > winnerPosition;
    }

    public boolean isSameThan(int winnerPosition) {
        return position == winnerPosition;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(UNIT_OF_POSITION);
        }
        return stringBuilder.toString();
    }
}

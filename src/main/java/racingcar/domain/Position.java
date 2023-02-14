package racingcar.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void updatePosition() {
        position++;
    }

    public int compareAndFindPosition(int maxPosition) {
        return Math.max(this.position, maxPosition);
    }

    public boolean isSamePosition(int winnerPosition) {
        return winnerPosition == this.position;
    }

    public int getPosition() {
        return position;
    }
}

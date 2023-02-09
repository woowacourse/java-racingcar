package domain;

import java.util.Objects;

public final class Status {
    public static final int NEXT_MOVE = 1;
    private static final int INIT_NUMBER = 0;
    private final int moveCount;

    private Status(int moveCount) {
        this.moveCount = moveCount;
    }

    public static Status INIT() {
        return new Status(INIT_NUMBER);
    }

    public Status next() {
        return new Status(moveCount + NEXT_MOVE);
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Status status = (Status) o;
        return moveCount == status.moveCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }
}

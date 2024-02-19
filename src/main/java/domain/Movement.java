package domain;

public enum Movement {
    MOVE, STAY;

    public boolean isMovable() {
        return this.equals(MOVE);
    }
}

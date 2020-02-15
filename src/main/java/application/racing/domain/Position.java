package application.racing.domain;

public class Position {
    private final static int MOVEMENT_NUMBER = 1;
    private final static int MOVING_STANDARD = 4;

    private int position;

    public Position() {
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_STANDARD) {
            this.position = this.position + MOVEMENT_NUMBER;
        }
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof Position)) {
            return false;
        }
        Position comparePosition = (Position) o;
        return comparePosition.position == this.position;
    }

    @Override
    public int hashCode() {
        return 31 + this.position;
    }
}

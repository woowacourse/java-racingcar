package application.racing.domain;

public class Position {
    private final static int MOVEMENT_NUMBER = 1;
    private final static int MOVING_STANDARD = 4;

    private int position;

    public Position() {
        this.position = 0;
    }

    public void move(int randomNumber) {
        validateRandomNumber(randomNumber);
        if (randomNumber >= MOVING_STANDARD) {
            this.position = this.position + MOVEMENT_NUMBER;
        }
    }

    private void validateRandomNumber(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException();
        }
    }

    public int getPosition() {
        return this.position;
    }
}

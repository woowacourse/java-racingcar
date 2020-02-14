package application.racing.domain;

public class Position {
    private final static int ONE = 1;
    private final static int FOUR = 4;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FOUR) {
            this.position = this.position + ONE;
        }
    }

    public int getPosition() {
        return this.position;
    }
}

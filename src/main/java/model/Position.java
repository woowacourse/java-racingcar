package model;

public class Position {

    private static final int MIN_MOVE_DELIMITER = 4;
    private static final int MIN_POSITION = 0;
    private static final int MOVE = 1;
    private int position;


    Position() {
        this.position = MIN_POSITION;
    }


    void move(int randomNumber) {
        if (validateMove(randomNumber)) {
            this.position += MOVE;
        }
    }

    private boolean validateMove(int randomNumber) {
        return randomNumber >= MIN_MOVE_DELIMITER;
    }

    public int getPosition() {
        return this.position;
    }
}

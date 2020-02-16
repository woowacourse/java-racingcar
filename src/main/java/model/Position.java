package model;

public class Position {

    public static final int MIN_MOVE_DELIMITER = 4;
    public static final int MIN_POSITION = 0;
    public static final int MOVE = 1;
    private int position;


    public Position() {
        this.position = MIN_POSITION;
    }


    public void move(int randomNumber) {
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

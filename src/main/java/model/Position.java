package model;

public class Position {

    private static final int MIN_MOVE_DELIMITER = 4;
    private static final int MIN_POSITION = 0;
    private static final int MOVE = 1;
    private int position;


    Position() {
        this.position = MIN_POSITION;
    }


    void move(int number) {
        if (validateMove(number)) {
            this.position += MOVE;
        }
    }

    boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    private boolean validateMove(int randomNumber) {
        return randomNumber >= MIN_MOVE_DELIMITER;
    }

    int getPosition() {
        return this.position;
    }
}

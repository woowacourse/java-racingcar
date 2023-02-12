package domain;

import validation.ErrorMessage;

public class Car {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final static int MIN_MOVE_NUMBER = 4;

    private final String name;
    private int moveCount;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validate(String name) {
        if (isEmptyOrBlank(name) || isWrongSizeName(name)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_CAR_NAME.getMessage());
        }
    }

    private boolean isEmptyOrBlank(String name) {
        return name.isEmpty() || name.isBlank();
    }

    private boolean isWrongSizeName(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    public void move() {
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean canMove(int number) {
        return number >= MIN_MOVE_NUMBER;
    }

    public boolean isWinner(int maxMoveCount) {
        return moveCount == maxMoveCount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}

package domain;

public class Car {

    private final static int MIN_MOVE_NUMBER = 4;

    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
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

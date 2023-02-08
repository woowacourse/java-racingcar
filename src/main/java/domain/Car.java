package domain;

public class Car {

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

    public boolean canMove(int generatedNumber, int minMoveNumber) {
        return generatedNumber >= minMoveNumber;
    }

    public boolean isWinner(int maxMoveCount) {
        return moveCount == maxMoveCount;
    }
}

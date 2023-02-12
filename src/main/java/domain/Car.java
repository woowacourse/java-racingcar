package domain;

import dto.CarDto;

public class Car {

    private final String name;
    private int moveCount;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.moveCount = 0;
    }

    public void move() {
        moveCount++;
    }

    public boolean canMove(int generatedNumber, int minMoveNumber) {
        return generatedNumber >= minMoveNumber;
    }

    public boolean isWinner(int maxMoveCount) {
        return moveCount == maxMoveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public CarDto toCarDto() {
        return new CarDto(name, moveCount);
    }

    private static void validate(String name) {
        CarValidator.validateCarName(name);
    }
}

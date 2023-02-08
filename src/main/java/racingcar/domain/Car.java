package racingcar.domain;

import racingcar.dto.CarStatus;

import static racingcar.constant.GameConstant.MINIMUM_NUMBER_TO_MOVE;

public class Car {
    private final String name;
    private final Position currentPosition;

    public Car(String name) {
        this.name = name;
        this.currentPosition = new Position();
    }

    public String getName() {
        return name;
    }

    public CarStatus move(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        if (isMovable(randomNumber)) {
            currentPosition.move();
        }
        return new CarStatus(name, currentPosition);
    }

    public CarStatus getCarStatus() {
        return new CarStatus(name, currentPosition);
    }

    public int compareTo(Car other) {
        return this.currentPosition.getPosition() - other.currentPosition.getPosition();
    }

    public boolean isSamePosition(Car target) {
        return currentPosition.equals(target.currentPosition);
    }

    public void validateName(String input) {
        if (input.length() > 5 || input.length() <1) {
            throw new IllegalArgumentException("이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    public void validateName(String input) {
        if (input.length() > 5 || input.length() <1) {
            throw new IllegalArgumentException("이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private boolean isMovable(int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }
}

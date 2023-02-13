package racingcar.domain;

import racingcar.constant.ErrorConstant;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private final String name;
    private final Position currentPosition;

    public Car(final String name, final int startPoint) {
        validateName(name);
        this.name = name;
        this.currentPosition = new Position(startPoint);
    }

    public String getName() {
        return name;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void move(final NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (isMovable(number)) {
            currentPosition.move();
        }
    }

    public int compareTo(final Car other) {
        return this.currentPosition.getPosition() - other.currentPosition.getPosition();
    }

    public boolean isSamePosition(final Car target) {
        return currentPosition.equals(target.currentPosition);
    }

    private boolean isMovable(final int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }

    private void validateName(final String input) {
        String name = removeBlank(input);
        if (name.length() > MAXIMUM_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private String removeBlank(String input) {
        return input.trim();
    }
}

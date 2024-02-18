package racingcar.domain;

public class Car {
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final String name;
    private final Position position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = new Position();
    }

    private void validateName(final String name) {
        if (name.isBlank() || name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    String.format("자동차의 이름은 공백이거나 %d자를 초과할 수 없습니다.", MAXIMUM_LENGTH_OF_NAME));
        }
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position.increase();
        }
    }

    public boolean isPositionEqualTo(int position) {
        return this.position.isMatchPosition(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }
}

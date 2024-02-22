package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        validateNameCharacters(name);
        validateNameLength(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void validateNameCharacters(String name) {
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("자동차의 이름은 영어로만 이루어져야 합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public boolean isWinner(int winnerPosition) {
        return this.position > 0 && this.position == winnerPosition;
    }
}

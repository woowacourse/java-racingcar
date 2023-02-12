package domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;
    private static final int POSITION_LOWER_BOUND_INCLUSIVE = 0;
    private static final int MOVE_FORWARD_NUMBER_LOWER_BOUND_INCLUSIVE = 4;
    private static final int MOVE_FORWARD_NUMBER_UPPER_BOUND_INCLUSIVE = 9;
    private static final String INVALID_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 1 ~ 5 글자여야 합니다";
    private static final String INVALID_POSITION_ERROR_MESSAGE = "위치는 0 이상 이어야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    // 테스트를 위해 생성자를 추가했습니다.
    public Car(String name, int position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > NAME_LENGTH_UPPER_BOUND_INCLUSIVE)
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_ERROR_MESSAGE);
    }

    // 테스트를 위해 position을 외부에서 주입하기를 허용했으므로 아래 메서드를 추가했습니다.
    private void validatePosition(int position) {
        if (position < POSITION_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(INVALID_POSITION_ERROR_MESSAGE);
        }
    }

    public void move(int number) {
        if (number >= MOVE_FORWARD_NUMBER_LOWER_BOUND_INCLUSIVE &&
                number <= MOVE_FORWARD_NUMBER_UPPER_BOUND_INCLUSIVE)
            position++;
    }

    @Override
    public int compareTo(Car other) {
        if (Objects.isNull(other)) throw new NullPointerException();
        return this.position - other.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

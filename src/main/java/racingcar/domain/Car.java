package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MOVING_DISTANCE = 1;
    private static final int NAME_MAXIMUM_LENGTH = 5;
    private static final CharSequence BLANK = " ";

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = START_POSITION;
    }
    
    private void validate(String name) {
        validateNullAndEmpty(name);
        validateLength(name);
        validateEachNameBlank(name);
    }
    
    private void validateEachNameBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("이름에는 공백을 입력할 수 없습니다.");
        }
    }
    
    private void validateLength(String name) {
        if (isCorrectLength(name)) {
            throw new IllegalArgumentException("1글자 이상 5글자 이하로 입력하세요.");
        }
    }
    
    private void validateNullAndEmpty(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("빈 문자열 및 공백은 입력할 수 없습니다.");
        }
    }
    
    private boolean isCorrectLength(String name) {
        return name.length() > NAME_MAXIMUM_LENGTH;
    }

    public void move(Movement movement) {
        if (movement.isMovable()) {
            position += MOVING_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}

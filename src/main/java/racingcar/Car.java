package racingcar;

import validator.CarNameValidator;

public class Car {
    private static final int START_POSITION = 0;
<<<<<<< HEAD
    private static final int MOVING_DISTANCE = 1;
=======
    private static final int NAME_MAXIMUM_LENGTH = 5;
>>>>>>> b3fc59f (test: 자동차 생성시 이름 길이 예외 처리 테스트)

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = position;
    }

<<<<<<< HEAD
=======
    private static void validateName(String name) {
        if (name.isEmpty() || name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LIMIT_EXCEPTION);
        }
    }

>>>>>>> b3fc59f (test: 자동차 생성시 이름 길이 예외 처리 테스트)
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position += MOVING_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

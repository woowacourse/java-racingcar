package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;
    private static final int MOVE_CRITERIA = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkNullName(name);
        name = name.trim();
        checkBlackName(name);
        checkLimitCharacters(name);

        this.name = name;
        this.position = position;
    }

    private void checkNullName(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("null 이름은 불가능합니다.");
        }
    }

    private void checkBlackName(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("공백 이름은 불가능합니다.");
        }
    }

    private void checkLimitCharacters(String carName) {
        if (carName.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(LIMIT_CAR_NAME_LENGTH + "자 이하의 자동차 이름만 허용됩니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car move(int randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
            this.position++;
        }
        return new Car(name, position);
    }

    /**
     * 자동차의 위치를 비교하는 메서드
     *
     * @param car
     * @return 매개변수의 위치가 더 멀면 1, 더 가까우면 -1, 같으면 0 반환
     */
    public int comparePosition(Car car) {
        int anotherPosition = car.position;

        if (position < anotherPosition) {
            return 1;
        }
        if (position > anotherPosition) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

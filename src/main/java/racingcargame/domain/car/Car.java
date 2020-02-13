package racingcargame.domain.car;

import java.util.Objects;

public class Car {

    private static final int CAR_NAME_LIMIT = 5;
    private static final int FORWARD_BASE_NUMBER = 4;

    private String name;
    private int position;

    public Car(String name) {
        validateNull(name);
        name = name.trim();
        validateCarName(name);
        this.name = name;
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
    }

    private void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다. 자동차 이름은 쉼표를 기준으로 구분합니다.");
        }
        if (name.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException("자동차 이름 길이 제한을 초과했습니다. 길이 제한은 " + CAR_NAME_LIMIT + "입니다.");
        }
    }

    public void move(int number) {
        if (number >= FORWARD_BASE_NUMBER) {
            position++;
        }
    }

    public boolean isSamePositionWith(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static int getCarNameLimit() {
        return CAR_NAME_LIMIT;
    }
}

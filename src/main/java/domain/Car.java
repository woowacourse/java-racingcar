package domain;

import java.util.Comparator;
import java.util.Objects;

public class Car {
    public static final int MAX_NAME_LEN = 5;
    public static final Comparator<Car> POSITION_COMPARATOR = Comparator.comparing(Car::getPosition);

    private final String name;
    private final int position;
    private final MoveStrategy moveStrategy;

    private Car(String name, int position, MoveStrategy moveStrategy) {
        if (name == null) {
            throw new IllegalArgumentException("name 이 null 입니다.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("name 이 빈문자열입니다.");
        }
        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(
                    String.format("입력된 이름의 길이가 너무 깁니다. %d 자 이하로 입력해주세요. (in: %s)", MAX_NAME_LEN, name));
        }

        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public static Car create(String name) {
        return new Car(name, 0, new RandomMoveStrategy());
    }

    public static Car create(String name, int position) {
        return new Car(name, position, new RandomMoveStrategy());
    }

    public static Car create(String name, int position, MoveStrategy moveStrategy) {
        return new Car(name, position, moveStrategy);
    }

    public Car move() {
        if (moveStrategy.canMove()) {
            return new Car(name, position + 1, moveStrategy);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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

package racinggame;

import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(Name.from(name), Position.from(0));
    }

    public static Car of(String name, int position) {
        return new Car(Name.from(name), Position.from(position));
    }

    // TODO : 테스트코드에서만 사용되고 있음.
    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.isMovable()) {
            this.position = position.increase();
        }
    }

    public CarInfo getInfo() {
        return new CarInfo(name.getName(), position.getPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

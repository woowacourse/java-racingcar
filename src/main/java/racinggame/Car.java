package racinggame;

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
}

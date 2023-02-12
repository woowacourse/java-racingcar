package racingcar.domain;

public class Car implements Comparable<Car> {
    private final Position position;
    private final CarName name;

    public Car(CarName carName) {
        this.name = carName;
        this.position = new Position();
    }

    public void move(CarMovement movement) {
        if (movement.isMove()) {
            this.position
                    .increasePosition();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPos() {
        return position
                .getValue();
    }

    @Override
    public int compareTo(Car o) {
        return this.position
                .compareTo(o.position
                );
    }
}

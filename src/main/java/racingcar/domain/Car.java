package racingcar.domain;

public class Car implements Comparable<Car> {
    private final Position position;
    private final CarName name;

    public Car(final CarName carName) {
        this.name = carName;
        this.position = new Position();
    }

    public void move(final CarMovement movement) {
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
    public int compareTo(final Car o) {
        return this.position
                .compareTo(o.position
                );
    }

    public boolean isSamePosition(final Car car) {
        return car.position.equals(this.position);
    }
}

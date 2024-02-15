package racingcar.domain.car;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final Position position;

    public Car(final String name) {
        this.name = new CarName(name);
        this.position = new Position(0);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }
}
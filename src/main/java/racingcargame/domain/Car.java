package racingcargame.domain;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void go(Engine engine) {
        if (engine.isHigherThanLimit()) {
            position.plus();
        }
    }

    public boolean isSameToPosition(Position position) {
        return position.isSameToPosition(position);
    }

    public boolean isSameToPosition(Car car) {
        return position.isSameToPosition(car.position);
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isSame(String name) {
        return this.name.equals(name);
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compare(o.position);
    }
}

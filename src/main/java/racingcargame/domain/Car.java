package racingcargame.domain;

public class Car implements Comparable<Car> {
    public static final int DEFAULT_POSITION = 0;

    private final Name name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void go(Engine engine) {
        if (engine.canMove()) {
            position++;
        }
    }

    public boolean isSamePositionWith(Car car) {
        return this.position == car.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public Car newClone() {
        return new Car(getName(), position);
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}

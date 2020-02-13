package racingcargame.domain;

public class Car implements Comparable<Car> {
    private final Name name;
    // TODO : POSITION으로 나누기
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void go(Engine engine) {
        if (engine.isHigherThanLimit()) {
            position++;
        }
    }

    public boolean isSameToPosition(int position) {
        return this.position == position;
    }

    public boolean isSameToPosition(Car car) {
        return this.position == car.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }

    public boolean isSame(String name) {
        return this.name.equals(name);
    }
}

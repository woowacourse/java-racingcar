package domain;

public class Car {

    private static final int MIN_BOUNDARY_POWER = 4;

    private final Name name;
    private Distance distance;

    public Car(final String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void move(final int power) {
        if (power >= MIN_BOUNDARY_POWER) {
            this.distance.increaseDistance();
        }
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public String getCarName() {
        return this.name.getName();
    }
}

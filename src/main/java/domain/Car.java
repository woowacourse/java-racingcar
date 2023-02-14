package domain;

public class Car {

    private static final int MIN_BOUNDARY_POWER = 4;

    private final CarName carName;
    private Distance distance;

    public Car(final String name, final int distance) {
        this.carName = new CarName(name);
        this.distance = new Distance(distance);
    }

    public void move(final int power) {
        if (power >= MIN_BOUNDARY_POWER) {
            this.distance.increase();
        }
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public String getCarName() {
        return this.carName.getName();
    }
}

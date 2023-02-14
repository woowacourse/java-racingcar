package domain;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int DEFAULT_INITIAL_POSITION = 0;

    private final CarName name;
    private int distance;

    public Car(String name) {
        this(name, DEFAULT_INITIAL_POSITION);
    }

    public Car(String name, int distance) {
        this.name = new CarName(name);
        this.distance = distance;
    }

    public void move(int power) {
        if (power >= THRESHOLD) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name.getName();
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Car
                && ((Car) object).getName()
                .equals(this.name.getName());
    }

    @Override
    public int hashCode() {
        return this.name.getName()
                .hashCode();
    }

}

package model;

public class Car {

    private static final int THROTTLE = 4;
    private static final int DEFAULT_INITIAL_POSITION = 0;
    private static final String STICK = "-";
    private static final String CAR_RESULT_FORMAT = "%s : %s\n";

    private final String name;
    private int distance;

    public Car(String name) {
        this(name, DEFAULT_INITIAL_POSITION);
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(int power) {
        if (power >= THROTTLE) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Car
                && ((Car) object).getName()
                .equals(this.name);
    }

    @Override
    public String toString() {
        return String.format(
                CAR_RESULT_FORMAT,
                name,
                STICK.repeat(distance)
        );
    }
}

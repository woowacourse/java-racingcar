package domain;

public class Car {
    private static final int MINIMUM_ADD_DISTANCE_POWER = 4;

    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void addDistance(int power) {
        if (power >= MINIMUM_ADD_DISTANCE_POWER) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object ob) {
        Car car = (Car)ob;
        return this.name.equals(car.name);
    }

}

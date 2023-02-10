package model;

import message.Constant;

public class Car {

    private static final int THROTTLE = 4;

    private final String name;

    private int distance;

    public Car(String name) {
        this(name, Constant.START_POSITION);
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

    private String getName() {
        return this.name;
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Car
                && ((Car) object).getName().equals(this.name);
    }

    @Override
    public String toString() {
        return String.format(Constant.CAR_RESULT_FORMAT, name, Constant.STICK.repeat(distance));
    }
}

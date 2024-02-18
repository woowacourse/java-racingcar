package domain.car;

import domain.power.Power;

public class Car {

    private final CarName name;
    private CarDistance distance;

    private Car(final CarName name, final CarDistance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car createCar(final String name) {
        return new Car(new CarName(name), CarDistance.getInitialDistance());
    }

    static Car createCar(final String name, final int distance) {
        return new Car(new CarName(name), new CarDistance(distance));
    }

    public void move(Power power) {
        if (power.isEnoughPower()) {
            distance = distance.getNextDistance();
        }
    }

    public boolean isAtDistance(CarDistance distance) {
        return distance.equals(this.distance);
    }

    public String getName() {
        return name.name();
    }

    public int getDistance() {
        return distance.distance();
    }
}

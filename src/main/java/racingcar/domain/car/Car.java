package racingcar.domain.car;

import racingcar.domain.power.Power;

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

package domain;

import domain.car.CarDistance;
import domain.car.CarName;
import dto.CarStatus;

public class Car {

    private static final int FORWARD_NUMBER = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final NumberRangeGenerator numberRangeGenerator;
    private final CarName name;
    private CarDistance distance;

    private Car(final NumberRangeGenerator numberRangeGenerator, final CarName name, final CarDistance distance) {
        this.numberRangeGenerator = numberRangeGenerator;
        this.name = name;
        this.distance = distance;
    }

    public static Car createCar(final String name) {
        return new Car(new RandomNumberRangeGenerator(), new CarName(name), CarDistance.getInitialDistance());
    }

    static Car createCar(final String name, final NumberRangeGenerator numberRangeGenerator) {
        return new Car(numberRangeGenerator, new CarName(name), CarDistance.getInitialDistance());
    }

    static Car createCar(final String name, final NumberRangeGenerator numberRangeGenerator, final int distance) {
        return new Car(numberRangeGenerator, new CarName(name), new CarDistance(distance));
    }

    public void move() {
        final int randomNumber = numberRangeGenerator.generateRandomNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (randomNumber >= FORWARD_NUMBER) {
            distance = distance.getNextDistance();
        }
    }

    public boolean isAtDistance(CarDistance distance) {
        return distance.equals(this.distance);
    }

    public CarStatus getStatus() {
        return new CarStatus(getName(), getDistance());
    }

    public String getName() {
        return name.name();
    }

    public int getDistance() {
        return distance.distance();
    }
}

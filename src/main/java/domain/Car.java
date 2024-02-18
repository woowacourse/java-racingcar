package domain;

import static domain.car.CarDistance.INITIAL_DISTANCE;

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

    public Car(final NumberRangeGenerator numberRangeGenerator, final CarName name, final CarDistance distance) {
        this.numberRangeGenerator = numberRangeGenerator;
        this.name = name;
        this.distance = distance;
    }

    public Car(final NumberRangeGenerator numberRangeGenerator, final CarName name) {
        this(numberRangeGenerator, name, CarDistance.getInitialDistance());
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

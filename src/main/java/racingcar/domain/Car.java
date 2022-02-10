package racingcar.domain;

public class Car {
    private static final int INITIAL_DISTANCE = 0;
    private final CarName carName;
    private int distance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        distance = INITIAL_DISTANCE;
    }

    public void move(boolean movement) {
        if (movement) {
            distance++;
        }
    }

    public String getCarName() {
        return carName.value();
    }

    public int getDistance() {
        return distance;
    }
 }

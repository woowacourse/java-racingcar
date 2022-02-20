package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MOVING_CAR_BOUND = 4;

    private final String carName;
    private int position;

    public Car(String carName) throws RuntimeException {
        CarNameValidator.validateCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    public void tryMoving(int randomNumber) {
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVING_CAR_BOUND;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car other) {
        return other.position - this.position;
    }
}

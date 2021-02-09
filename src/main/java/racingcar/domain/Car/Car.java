package racingcar.domain.Car;

public class Car {
    private final int ACCELERATE_THRESHOLD = 4;
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;
    private final CarName carName;
    private int position;

    public Car(final String name) {
        this.position = 1;
        this.carName = new CarName(name);
    }

    public void drive(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new RuntimeException("0과 9사이의 값이어야만 합니다.");
        }

        if (value >= ACCELERATE_THRESHOLD) {
            accelerate();
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    private void accelerate() {
        position++;
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", carName=" + carName +
                '}';
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.carName.equals(car.carName);
        }
        return false;
    }
}
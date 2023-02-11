package domain;

public class Car {

    private final String carName;
    private int position;

    public Car(final String carName) {
        this.carName = carName;
        position = 0;
    }

    public Car(final Car car) {
        carName = car.getCarName();
        position = car.getPosition();
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}

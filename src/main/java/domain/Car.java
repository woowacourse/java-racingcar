package domain;

public class Car {

    private final String carName;
    private int position;

    public Car(final String carName) {
        this.carName = carName;
        position = 0;
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

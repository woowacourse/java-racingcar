package domain;

public class Car {

    private int position;
    private final String carName;

    public Car(String carName) {
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

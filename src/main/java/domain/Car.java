package domain;

public class Car {

    private final CarName carName;
    private int status;

    public Car(String carName) {
        this.carName = new CarName(carName);
        status = 0;
    }

    public void move() {
        status++;
    }

    public int getStatus() {
        return status;
    }
}

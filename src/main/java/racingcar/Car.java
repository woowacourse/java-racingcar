package racingcar;

public class Car {
    private final CarName carName;
    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void moveForward() {
        position += 1;
    }



}

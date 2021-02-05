package racingcar;

public class Car {
    private final CarName carName;
    private static final int CONDITION = 4;
    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void moveForwardByRandomNumber(int randomNumber) {
        if (randomNumber >= CONDITION) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}

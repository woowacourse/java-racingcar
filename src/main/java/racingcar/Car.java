package racingcar;

public class Car {
    private final CarName carName;
    private static final int CONDITION = 4;
    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            positionBar.append("-");
        }
        return this.carName.getCarName() + " : " + positionBar;
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

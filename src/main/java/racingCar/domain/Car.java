package racingCar.domain;

public class Car {

    private static final int MIN_POWER = 4;

    private final CarName name;
    private int position;

    public Car(String carName, int initPosition) {
        name = new CarName(carName);
        position = initPosition;
    }

    public void move(int power) {
        if (power >= MIN_POWER) {
            position++;
        }
    }

    public boolean isSamePosition(int otherPosition) {
        return this.position == otherPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}

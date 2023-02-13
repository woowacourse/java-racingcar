package racingCar.domain;

public class Car {

    private static final int MIN_FUEL = 4;

    private final CarName name;
    private int position;

    public Car(String carName, int initPosition) {
        name = new CarName(carName);
        position = initPosition;
    }

    public void move(int fuel) {
        if (fuel >= MIN_FUEL) {
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

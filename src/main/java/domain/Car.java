package domain;

public class Car {

    private final CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
        position = 0;
    }

    public void move() {
        position++;
    }

    public int comparePosition(Car otherCar) {
        return this.position - otherCar.position;
    }

    public boolean hasSamePositionWith(Car otherCar) {
        return comparePosition(otherCar) == 0;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName.getCarName();
    }
}


package racingCar;

public class Car {
    private final CarName carName;
    private Distance distance;

    public Car(final String name) {
        this.carName = new CarName(name);
        this.distance = new Distance(0);
    }

    public void move(int number) {
        distance.move(number);
    }

    public boolean isWinner(int max) {
        return distance.isMaxDistance(max);
    }

    public CarName getName() {
        return carName;
    }

    public int getDistance() {
        return distance.getDistance();
    }
}

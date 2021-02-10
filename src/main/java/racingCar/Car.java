package racingCar;

public class Car {
    private final Name name;
    private Distance distance;

    public Car(final String name) {
        this.name = new Name(name);
        this.distance = new Distance(0);
    }

    public void move(int number) {
        distance.move(number);
    }

    public boolean isWinner(int max) {
        return distance.isMaxDistance(max);
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}

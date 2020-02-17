package racingcargame.domain;

public class Car implements Comparable<Car> {
    private static final int GO_CONDITION = 4;

    private Name name;
    private Position carPosition;

    public Car(String name) {
        this.name = new Name(name);
        this.carPosition = new Position();
    }

    public Car(Car car) {
        this.name = new Name(car.getName());
        this.carPosition = new Position(car.getCarPosition());
    }

    public void decideGoOrStop(int number) {
        if (number >= GO_CONDITION) {
            carPosition.increase();
            this.carPosition = new Position(this.getCarPosition());
        }
    }

    public int getCarPosition() {
        return carPosition.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car c) {
        return c.getCarPosition() - getCarPosition();
    }
}

package racingCar.model;

public class Car {
    private static final int GO_NUMBER = 4;
    public final Name name;
    public final Position position = new Position();

    public Car(String name) {
        this.name = new Name(name);
    }

    public void go(int number) {
        if (number >= GO_NUMBER) {
            move();
        }
    }

    public void move() {
        position.move();
    }
}
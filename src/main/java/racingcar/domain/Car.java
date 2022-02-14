package racingcar.domain;

public class Car {
    private final CarName name;
    private int position;
    private final MovingPolicy movingPolicy;

    public Car(String name, MovingPolicy movingPolicy) {
        this.name = new CarName(name);
        this.position = 0;
        this.movingPolicy = movingPolicy;
    }

    public void move() {
        if (movingPolicy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}

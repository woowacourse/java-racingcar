package domain;

public class Car {
    private final CarName name;
    private Integer distance = 0;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            distance++;
        }
    }

    public Integer getDistance() {
        return distance;
    }
}

package domain;

public class Car {
    private final CarName carName;
    private Integer distance = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public void move(MovementManager movementManager, Integer power) {
        if (movementManager.isGo(power)) {
            distance++;
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public Integer getDistance() {
        return distance;
    }
}

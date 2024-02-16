package domain;

public class Car {

    private final CarName carName;
    private Integer position;

    private final PowerStrategy powerStrategy;

    private Car(CarName carName, int position) {
        this.carName = carName;
        this.position = position;
        this.powerStrategy = PowerStrategy.from();
    }

    public static Car of(String name, int position) {
        CarName carName = CarName.from(name);
        return new Car(carName, position);
    }

    public Integer getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    public void tryMove() {
        if (canMove()) {
            move();
        }
    }

    private boolean canMove() {
        return powerStrategy.checkRandomNumberRange();
    }

    private void move() {
        position++;
    }
}

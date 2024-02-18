package domain.car;

import domain.car.moveStrategy.MoveStrategy;

public class Car {

    private final CarName name;
    private int location;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new CarName(name);
        this.moveStrategy = moveStrategy;
        location = 0;
    }

    public void tryMove() {
        if (moveStrategy.canGo()) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name.getName();
    }
}

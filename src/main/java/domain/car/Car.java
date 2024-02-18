package domain.car;

import domain.moveStrategy.MoveStrategy;

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

    public boolean isLocatedAt(int location) {
        return this.location == location;
    }

    public CarRoundResult createResult(){
        return new CarRoundResult(this.name.getName(), this.location);
    }
}

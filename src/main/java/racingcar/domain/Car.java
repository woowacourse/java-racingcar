package racingcar.domain;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final Position pos;

    public Car(String carName) {
        this.name = new CarName(carName);
        this.pos = new Position();
    }

    public void move(CarMovement movement) {
        if(movement.isMove()){
            this.pos.increasePosition();
        }
    }

    public String getName() {
        return name.getName();
    }

    public Integer getPos() {
        return pos.getValue();
    }

    @Override
    public int compareTo(Car o) {
        return this.pos.compareTo(o.pos);
    }

}

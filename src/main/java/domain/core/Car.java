package domain.core;

import domain.vo.Distance;
import domain.vo.Name;

public class Car {

    private static final int MOVABLE_CONDITION_VALUE = 4;

    private static final int MOVE_DISTANCE_VALUE = 1;

    private final Name name;
    private Distance distance;

    public Car(Name name) {
        this.name = name;
        this.distance = Distance.initial();
    }

    public Distance move(int number) {
        if (number >= MOVABLE_CONDITION_VALUE) {
            distance = distance.plus(MOVE_DISTANCE_VALUE);
        }
        return this.distance;
    }

    public boolean isSameDistance(Distance distance) {
        return this.distance.equals(distance);
    }

    public String name() {
        return name.value();
    }

    public int distance() {
        return distance.value();
    }
}

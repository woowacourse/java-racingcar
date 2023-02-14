package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MOVE_LOWER_BOUND = 4;

    private final String name;
    private int distance;
    private List<Integer> distanceRecord;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        distanceRecord = new ArrayList<>();
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
        distanceRecord = new ArrayList<>();
    }

    public void move(int power) {
        if (power >= MOVE_LOWER_BOUND) {
            this.distance++;
        }
        distanceRecord.add(this.distance);
    }

    public boolean isWinner(int distance) {
        return this.distance == distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getDistanceRecord(int index) {
        return distanceRecord.get(index);
    }
}

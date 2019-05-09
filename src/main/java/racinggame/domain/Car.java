package racinggame.domain;

import java.util.HashMap;

public class Car {
    private static final int ONE_STEP = 1;
    private static final int THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean run(int number) {
        if (number >= THRESHOLD) {
            position += ONE_STEP;
            return true;
        }
        return false;
    }

    public HashMap<String, Integer> makeCarHistory() {
        HashMap<String, Integer> carHistory = new HashMap<>();

        carHistory.put(name, position);
        return carHistory;
    }
}

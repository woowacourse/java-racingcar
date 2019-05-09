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

    void run(int number) {
        if (number >= THRESHOLD) {
            position += ONE_STEP;
        }
    }

    public HashMap<String, Integer> makeCarHisory() {
        HashMap<String, Integer> carHisttory = new HashMap<>();

        carHisttory.put(name, position);
        return carHisttory;
    }
}

package racingcar.domain;

import racingcar.domain.engine.Engine;

public class Car {

    private static final String GO_FORWARD_MARKING = "-";
    private static final int GO_FORWARD_DISTANCE = 1;
    public static final int DEFAULT_CAR_POSITION = 0;

    private String name;
    private Engine engine;
    private int position = DEFAULT_CAR_POSITION;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public void run() {
        if (engine.isMove()) {
            position += GO_FORWARD_DISTANCE;
        }
    }

    public String displayCurrentStatus() {
        return name + " : " + displayCurrentPosition();
    }

    private String displayCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            currentPosition.append(GO_FORWARD_MARKING);
        }
        return currentPosition.toString();
    }

    public boolean isOn(int max) {
        return position == max;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

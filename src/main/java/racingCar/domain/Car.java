package racingCar.domain;

import racingCar.domain.Engine.Engine;

public class Car {


    private static final int GO_FORWARD_DISTANCE = 1;

    private final String name;
    private final Engine engine;
    private int position = 0;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public void run() {
        if (engine.isMove()) {
            position += GO_FORWARD_DISTANCE;
        }
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

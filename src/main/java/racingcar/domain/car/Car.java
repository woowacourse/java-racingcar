package racingcar.domain.car;

import racingcar.domain.engine.Engine;

public class Car {

    private static final String GO_FORWARD_MARKING = "-";
    private static final int GO_FORWARD_DISTANCE = 1;
    public static final int DEFAULT_CAR_POSITION = 0;

    private Name name;
    private Engine engine;
    private Position position;

    public Car(String name, Engine engine) {
        this.name = Name.of(name);
        this.engine = engine;
        this.position = Position.of(DEFAULT_CAR_POSITION);
    }

    public void run() {
        if (engine.isMove()) {
            this.position = position.plus(GO_FORWARD_DISTANCE);
        }
    }

    public String displayCurrentStatus() {
        return name.getValue() + " : " + displayCurrentPosition();
    }

    private String displayCurrentPosition() {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position.getValue(); i++) {
            currentPosition.append(GO_FORWARD_MARKING);
        }
        return currentPosition.toString();
    }

    public boolean isOn(int max) {
        return position.getValue() == max;
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getValue();
    }
}

package racingCar.domain;

import racingCar.domain.Engine.Engine;
import racingCar.domain.Engine.RandomEngine;

public class Car {


    private static final int GO_FORWARD_DISTANCE = 1;

    private final Name name;
    private final Engine engine;
    private Position position;


    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position) {
        this(name, new Position(position));
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.engine = new RandomEngine();
        this.position = position;
    }

    public void run() {
        if (engine.isMove()) {
            position = position.goForward();
        }
    }

    public boolean isOn(int max) {
        return position.getPosition() == max;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName(){
        return name.getName();
    }

}

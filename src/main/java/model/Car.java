package model;

import model.wrapper.Name;
import model.wrapper.Position;
import utils.RacingNumberGenerator;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void race(RacingNumberGenerator generator) {
        position.move(generator);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}

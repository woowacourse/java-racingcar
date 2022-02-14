package racingCar.model;

import racingCar.model.utlis.Util;

public class Car {
    public final Name name;
    public final Position position = new Position();

    public Car(String name) {
        this.name = new Name(name);
    }

    public void go() {
        final int goNumber = 4;
        if (Util.getRandomInteger() >= goNumber) {
            move();
        }
    }

    public void move() {
        position.move();
    }
}
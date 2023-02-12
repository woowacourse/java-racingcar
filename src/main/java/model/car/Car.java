package model.car;

import util.validator.CarNameValidator;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        new CarNameValidator().validate(name);
        this.name = name;
    }

    public void move(boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}

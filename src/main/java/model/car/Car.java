package model.car;

import util.validator.CarNameValidator;

public class Car {

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name =  new CarName(name);
    }

    public void move(boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}

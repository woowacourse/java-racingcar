package racingcargame.model;

import racinginterface.CarInterface;

public class Car implements CarInterface {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void moveOrNot() {
        if ((int) (Math.random() * 10) >= 4) {
            position++;
        }
    }
}

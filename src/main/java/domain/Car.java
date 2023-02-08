package domain;

import static utils.Constant.MOVING_STANDARD_NUM;

public class Car {

    private final Name name;
    private StringBuffer position = new StringBuffer();

    public Car(Name name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVING_STANDARD_NUM) {
            position.append("-");
        }
    }

    public String getStatus() {
        return name.getName() + " : " + position;
    }

    public int getPosition() {
        return position.length();
    }

    public String getName() {
        return name.getName();
    }
}

package racingcar;

import static racingcar.RandomGenerator.*;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void goForward() {
        if (isCarGoForward()) {
            position++;
        }
    }

    private boolean isCarGoForward() {
        if (getRandomNumberInRange(9) >= 4) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }
}

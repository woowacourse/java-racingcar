package racingcar;

import static racingcar.RandomGenerator.*;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name)
                .append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

}

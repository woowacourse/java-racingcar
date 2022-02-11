package racingcar.domain;

import static racingcar.utils.RandomGenerator.*;

public class Car {

    private static final int MAX_RANDOM_RANGE = 9;
    private static final int MIN_GO_FORWARD_RANGE = 4;
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String PROGRESS_BAR = "-";

    final private String name;
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
        if (getRandomNumberInRange(MAX_RANDOM_RANGE) >= MIN_GO_FORWARD_RANGE) {
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
                .append(NAME_POSITION_DELIMITER);
        for (int i = 0; i < position; i++) {
            stringBuilder.append(PROGRESS_BAR);
        }
        return stringBuilder.toString();
    }

}

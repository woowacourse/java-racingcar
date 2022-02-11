package racingcar.domain;

import static racingcar.utils.RandomGenerator.*;

public class Car {

    private static final int MAX_RANDOM_RANGE = 9;
    private static final int MIN_GO_FORWARD_RANGE = 4;
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String PROGRESS_BAR = "-";

    private final String name;
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
        return getRandomNumberInRange(MAX_RANDOM_RANGE) >= MIN_GO_FORWARD_RANGE;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name)
                .append(NAME_POSITION_DELIMITER);
        stringBuilder.append(PROGRESS_BAR.repeat(position));
        return stringBuilder.toString();
    }

}

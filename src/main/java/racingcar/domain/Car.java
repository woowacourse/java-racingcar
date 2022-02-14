package racingcar.domain;

public class Car {

    private static final int MIN_GO_FORWARD_RANGE = 4;

    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward(int number) {
        if (isCarGoForward(number)) {
            position++;
        }
    }

    private boolean isCarGoForward(int number) {
        return number >= MIN_GO_FORWARD_RANGE;
    }
}

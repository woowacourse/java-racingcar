package racingcar.domain;

public class Distance {
    private int value;

    public Distance(int value) {
        this.value = value;
    }

    public void increaseDistance() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}

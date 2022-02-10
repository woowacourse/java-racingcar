package racingcar.domain.car;

public class Position {

    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public boolean isSame(int num) {
        return value == num;
    }
}

package racing.domain.car;

public class Position {
    private static final int DEFAULT_START_POSITION = 0;
    private int value = DEFAULT_START_POSITION;

    public Position() {
    }

    public Position(int step) {
        this.value = step;
    }

    public void add(int step) {
        this.value += step;
    }

    public int getValue() {
        return value;
    }
}

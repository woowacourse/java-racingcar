package racingcar.domain;

public class Car {
    private static final int THRESHOLD = 4;
    private static final String DELIMITER = " : ";
    private static final String DISTANCE = "-";

    private final String name;
    private final Engine engine;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.engine = new Engine();
        this.position = position;
    }

    public void move(int power) {
        if (power >= THRESHOLD) {
            position++;
        }
    }

    public int startEngine() {
        return engine.ignite();
    }

    public boolean isSamePosition(int highScore) {
        return position == highScore;
    }

    public String getProgress() {
        StringBuilder currentPosition = new StringBuilder(name + DELIMITER);
        for (int i = 0; i < position; i++) {
            currentPosition.append(DISTANCE);
        }
        return currentPosition.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

package racingcar.domain;

public class Car {
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void move(int moveNumber) {
        if (moveNumber >= BOUNDARY) {
            this.position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}

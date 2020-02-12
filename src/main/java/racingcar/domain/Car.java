package racingcar.domain;

public class Car {
    public static final int CRITERIA = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void movePositionAccordingToCondition(int value) {
        if (value >= CRITERIA) {
            move();
        }
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

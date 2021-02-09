package racingcar.domain;

public class Car {
    private static final int MOVE_BOUND = 4;
    private static final String DASH = "-";

    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void move(MoveValueStrategy moveValueStrategy) {
        if (moveValueStrategy.createMoveValue() >= MOVE_BOUND) {
            position++;
        }
    }

    public String positionToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
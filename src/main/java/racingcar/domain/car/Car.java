package racingcar.domain.car;

public class Car {

    private static final int MOVE_BOUND = 4;

    private final Name name;
    private int position = 0;

    public Car(final String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_BOUND) {
            position++;
        }
    }

    public String positionToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public boolean isMaxPosition(final int maxPosition) {
        return position == maxPosition;
    }
}
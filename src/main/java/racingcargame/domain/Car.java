package racingcargame.domain;

public class Car {

    private static final int CAR_NAME_LIMIT = 5;
    private static final int FORWARD_BASE_NUMBER = 4;

    private String name;
    private int position;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int number) {
        if (number >= FORWARD_BASE_NUMBER) {
            position++;
        }
    }

    public boolean isSamePositionWith(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

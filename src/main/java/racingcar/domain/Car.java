package racingcar.domain;

public class Car {

    private static final int POSITION_INITIAL_VALUE = 0;
    private static final int PROGRESS_CONDITION_VALUE = 4;

    private final CarName carName;
    private int position = POSITION_INITIAL_VALUE;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public void progress(int number) {
        if (number >= PROGRESS_CONDITION_VALUE) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }
}


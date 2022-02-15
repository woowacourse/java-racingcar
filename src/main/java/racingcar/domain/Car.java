package racingcar.domain;

public class Car implements Cloneable {

    private static final int START_POSITION = 0;
    public static final String CLONING_FAIL_CAR_NAME = "cloning fail";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void forwardCarPosition() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Car(CLONING_FAIL_CAR_NAME);
        }
    }
}

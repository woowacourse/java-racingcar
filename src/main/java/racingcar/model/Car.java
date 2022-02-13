package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void forward(boolean canForward) {
        if (canForward) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePositionWith(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }
}

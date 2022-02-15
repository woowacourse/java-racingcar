package racingcar.model;

import racingcar.utils.NameValidator;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name) {
        NameValidator.isValidateName(name);
        this.name = name;
    }

    public void forward(boolean canForward) {
        if (canForward) {
            this.position += 1;
        }
    }

    public boolean isSamePositionWith(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}

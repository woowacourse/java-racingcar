package racingcar.domain.car;

import racingcar.domain.rule.CarMoveCondition;
import racingcar.view.Marks;

import static racingcar.view.Marks.colon;

public class Car {
    private int position;
    private CarMoveCondition moveCondition;
    private CarName name;

    public Car(String name, CarMoveCondition moveCondition) {
        this.moveCondition = moveCondition;
        this.name = new CarName(name);
    }

    public void move() {
        if (!moveCondition.isMovable()) {
            return;
        }

        position++;
    }

    public int getPosition() {
        return position;
    }

    public CarName getName() {
        return name;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Car)) {
            return false;
        }

        return name.equals(((Car) o).name);
    }

    @Override
    public String toString() {
        return name.toString() + " " + colon + " " + Marks.dash.repeat(position);
    }
}

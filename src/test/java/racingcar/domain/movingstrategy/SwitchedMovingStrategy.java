package racingcar.domain.movingstrategy;

import racingcar.domain.Car;

public class SwitchedMovingStrategy implements MovingStrategy {
    private boolean movingStatus = true;

    @Override
    public Car move(Car car) {
        toggleStatus();
        if (movingStatus) {
            return car.moveDefinitely();
        }
        return car;
    }

    private void toggleStatus() {
        this.movingStatus = !movingStatus;
    }
}

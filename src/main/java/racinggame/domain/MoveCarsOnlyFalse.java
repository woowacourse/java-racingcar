package racinggame.domain;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Strategy;

public class MoveCarsOnlyFalse implements Strategy {
    public int moveCars(Cars cars, int maxPosition) {
        for (Car car : cars) {
            if (car.move(0)) {
                maxPosition = car.getMaxPosition(maxPosition);
            }
        }
        return maxPosition;
    }
}

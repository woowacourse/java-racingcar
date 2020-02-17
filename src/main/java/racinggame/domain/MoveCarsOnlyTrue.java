package racinggame.domain;

public class MoveCarsOnlyTrue implements Strategy {
    public int moveCars(Cars cars, int maxPosition) {
        for (Car car : cars) {
            if (car.move(7)) {
                maxPosition = car.getMaxPosition(maxPosition);
            }
        }
        return maxPosition;
    }
}

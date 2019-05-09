package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxDistance() {
        cars.sort((Car car1, Car car2) -> car2.getPosition() - car1.getPosition());
        return cars.get(0).getPosition();
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxDistance();
        int carNumber = 0;
        while (checkMaxLength(carNumber) && checkMaxPosition(carNumber, maxPosition)) {
            winners.add(cars.get(carNumber++));
        }
        return winners;
    }

    private boolean checkMaxLength(int carNumber) {
        return carNumber < cars.size();
    }

    private boolean checkMaxPosition(int index, int maxPosition) {
        return cars.get(index).isMaxPosition(maxPosition);
    }

}

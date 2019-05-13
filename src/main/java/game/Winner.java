package game;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winners = new ArrayList<>();
    private int maxInstance = 0;

    public void selectWinners(List<Car> cars) {
        checkMaxInstance(cars);
        for (Car car : cars) {
            addWinner(car);
        }
    }

    private void addWinner(Car car) {
        if (isMaxInstance(car)) {
            addWinners(car.getName());
        }
    }

    private boolean isMaxInstance(Car car) {
        return car.getPosition() == maxInstance;
    }

    private void checkMaxInstance(List<Car> cars) {
        for (Car car : cars) {
            maxInstance = Math.max(maxInstance, car.getPosition());
        }
    }

    private void addWinners(String carName) {
        winners.add(carName);
    }

    public List<String> getWinners() {
        return winners;
    }
}

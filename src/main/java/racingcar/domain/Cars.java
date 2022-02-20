package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        int maxNum = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        return maxNum;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
                cars.stream()
                .filter(car -> car.checkIfPositionSame(getMaxPosition()))
                .forEach(car -> winners.add(car.getName()));
        return winners;
    }
}

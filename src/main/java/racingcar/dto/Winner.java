package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> carList;
    private int maxDistance = 0;

    public Winner(List<Car> carList, int maxDistance) {
        this.carList = carList;
        this.maxDistance = maxDistance;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void getMaxDistance() {
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }
}

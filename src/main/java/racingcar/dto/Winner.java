package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> carList;
    private int maxDistance = 0;

    public Winner(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();

        getMaxDistance();
        for (Car car : carList) {
            if (car.getPosition() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private void getMaxDistance() {
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }
}

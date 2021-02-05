package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {

    private List<String> winners = new ArrayList<>();
    private int maxPosition = -1;

    public List<String> getWinners(List<Car> cars) {
        for (Car car : cars) {
            updateWinners(car);
        }
        return winners;
    }

    private void updateWinners(Car car) {
        if (car.getPosition() < maxPosition) {
            return;
        }
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
            winners.clear();
        }
        winners.add(car.getName());
    }

}

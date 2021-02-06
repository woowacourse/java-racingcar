package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<String> winners = new ArrayList<>();

    public List<String> makeWinners(List<Car> cars) {
        int winnerPosition = 0;

        for (Car car : cars) {
            winnerPosition = findMaxPosition(winnerPosition, car);
        }

        for (Car car : cars) {
            addWinners(winnerPosition, car);
        }

        return this.winners;
    }

    private void addWinners(int winnerPosition, Car car) {
        if(car.getPosition().isSameThan(winnerPosition)){
            winners.add(car.getName().getName());
        }
    }

    private int findMaxPosition(int winnerPosition, Car car) {
        if (car.getPosition().isSmallerThan(winnerPosition)) {
            return winnerPosition;
        }
        if (car.getPosition().isBiggerThan(winnerPosition)) {
            winnerPosition = car.getPosition().getPosition();
        }
        return winnerPosition;
    }
}

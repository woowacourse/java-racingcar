package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> carList;

    public Winner(List<Car> carList) {
        this.carList = carList;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : carList) {
            maxPosition = car.getBiggerPosition(maxPosition);
        }

        return maxPosition;
    }

    public List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : carList) {
            if (car.isMaxPosition(maxPosition)) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}

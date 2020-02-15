package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final List<String> winners = new ArrayList<>();

    private Winner() {
    }

    public static List<String> getWinners(List<Car> carList) {
        int max = getWinnerPosition(carList);
        for (Car car : carList) {
            if (car.isWinner(max)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static int getWinnerPosition(List<Car> carList) {
        int maxPosition = Integer.MIN_VALUE;
        int position;

        for (Car car : carList) {
            position = car.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }

}

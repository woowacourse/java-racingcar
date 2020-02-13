package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

public class Winner {
    private static final List<String> winners = new ArrayList<>();
    private static final String COMMA = ",";

    private Winner() {
    }

    public static String getWinners(List<Car> carList) {
        int max = getWinnerPosition(carList);
        for (Car car : carList) {
            if (car.isWinner(max)) {
                winners.add(car.getName());
            }
        }
        return String.join(COMMA, winners);
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

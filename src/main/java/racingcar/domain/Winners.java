package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class Winners {

    private Winners() {
    }

    public static List<String> toList(final List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            maxPosition = renewMaxPosition(maxPosition, winners, car);
        }

        return winners;
    }

    private static int renewMaxPosition(int maxPosition, final List<String> winners, final Car car) {
        if (car.getPosition().length() < maxPosition) {
            return maxPosition;
        }
        if (car.getPosition().length() > maxPosition) {
            winners.clear();
            maxPosition = car.getPosition().length();
        }
        winners.add(car.getName());
        return maxPosition;
    }

}

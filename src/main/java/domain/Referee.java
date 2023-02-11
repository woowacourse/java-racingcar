package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private static final int CAN_NOT_FIND_MAX = -1;

    public Cars judgeWinner(Cars cars) {
        int maxPosition = findMaxPosition(cars);

        List<Car> winner = cars.getStream()
                .filter(car -> car.hasSamePosition(maxPosition))
                .collect(Collectors.toList());

        return new Cars(winner);
    }

    private int findMaxPosition(Cars cars) {
        return cars.getStream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(CAN_NOT_FIND_MAX);
    }
}

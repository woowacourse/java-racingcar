package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingcarService {

    public void move(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomMaker.random());
        }
    }

    public List<Car> findWinner(List<Car> cars) {
        int winnerPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .collect(Collectors.toList());
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }

        return maxPosition;
    }
}

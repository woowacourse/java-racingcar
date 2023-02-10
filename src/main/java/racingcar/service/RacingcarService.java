package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingcarService {

    public void move(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomMaker.random());
        }
    }

    public List<Car> findWinner(List<Car> cars) {
        int winnerPosition = findPosition(cars);

        return cars.stream()
                .filter(car -> car.isPosition(winnerPosition))
                .collect(Collectors.toList());
    }

    private int findPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }

        return maxPosition;
    }
}

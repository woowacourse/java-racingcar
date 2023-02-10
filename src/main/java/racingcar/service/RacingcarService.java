package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingcarService {

    private final CarFactory carFactory;

    public RacingcarService() {
        this.carFactory = new CarFactory();
    }

    public void move(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomMaker.random());
        }
    }

    public List<Car> findWinner(List<Car> cars, int winnerPosition) {
        return cars.stream()
                .filter(car -> car.isPosition(winnerPosition))
                .collect(Collectors.toList());
    }

    public int findPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }

        return maxPosition;
    }

    public List<Car> getCar(String carNames) {
        return carFactory.makeCars(carNames);
    }
}

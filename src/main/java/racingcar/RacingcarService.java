package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingcarService {

    private final CarFactory carFactory;

    public RacingcarService() {
        this.carFactory = new CarFactory();
    }

    public List<Car> makeCars(String carNames) {
        return carFactory.makeCars(carNames);
    }

    public void move(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomMaker.random());
        }
    }

    public int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }

        return maxPosition;
    }

    public List<Car> findWinner(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }
}

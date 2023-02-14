package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.MovingStrategy;
import racingcar.RandomMovingStrategy;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();

        for (Car car : cars) {
            car.move(randomMovingStrategy);
        }
    }

    public List<String> getResult(String positionSign) {
        return cars.stream()
                .map(car -> car.getResult(positionSign))
                .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }

        return maxPosition;
    }
}

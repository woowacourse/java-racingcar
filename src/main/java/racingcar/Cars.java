package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(car -> car.move(RandomMaker.random()));
    }

    public List<String> getResult() {
        List<String> result = new ArrayList<>();

        for (Car car : cars) {
            result.add(car.getResult());
        }

        return result;
    }

    public int findMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }

        return maxPosition;
    }

    public List<Car> findWinners(int winnerPosition) {
        return cars
                .stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .collect(Collectors.toList());
    }
}

package racingcar.domain;

import java.util.stream.Collectors;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public Cars(List<String> carNameList) {
        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }

    public void processOneTurn() {
        carList.forEach(car -> car.oneTurn(RandomNumberGenerator.turnNumber()));
    }

    public List<Car> getList() {
        return this.carList;
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return carList.stream()
            .filter(carElement -> (carElement.isSamePosition(maxPosition)))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
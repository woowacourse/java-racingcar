package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {
    public List<String> generateWinners(List<Car> carList){
        int maxPosition = 0;

        for(Car car : carList){
            maxPosition = car.comparePosition(maxPosition);
        }

        return findWinners(carList, maxPosition);
    }

    private List<String> findWinners(List<Car> carList, int maxPosition) {
        return carList.stream()
                .filter(car -> car.matchesPosition(maxPosition))
                .map(Car::getName)
                .toList();
    }

}

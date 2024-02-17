package racing.domain;

import java.util.List;
import java.util.Map;

class Racing {
    private final int maxTurn;
    private final Cars cars;
    private int nowTurn = 1;

    Racing(int maxTurn, Cars cars) {
        this.maxTurn = maxTurn;
        this.cars = cars;
    }

    void nextTurn(List<Integer> racingConditions) {
        if (nowTurn <= maxTurn) {
            nowTurn += 1;
            cars.move(racingConditions);
        }
    }

    Map<String, Integer> getCarsStatus() {
        return cars.getCarsStatus();
    }

    List<String> getWinnerNames() {
        List<Car> maxCars = cars.getMax();
        return maxCars.stream()
                .map(Car::getName)
                .toList();
    }
}

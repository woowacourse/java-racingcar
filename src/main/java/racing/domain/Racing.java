package racing.domain;

import java.util.List;
import java.util.Map;

public class Racing {
    private final int maxTurn;
    private final Cars cars;
    private int nowTurn = 1;

    public Racing(int maxTurn, Cars cars) {
        this.maxTurn = maxTurn;
        this.cars = cars;
    }

    public void nextTurn(List<Integer> racingConditions) {
        if (nowTurn <= maxTurn) {
            nowTurn += 1;
            cars.move(racingConditions);
        }
    }

    public Map<String, Integer> getCarsStatus() {
        return cars.getCarsStatus();
    }

    public List<String> getWinnerNames() {
        List<Car> maxCars = cars.getMax();
        return maxCars.stream()
                .map(Car::getName)
                .toList();
    }
}

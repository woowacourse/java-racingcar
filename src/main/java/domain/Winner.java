package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<String> winnerNames;

    public Winner() {
        this.winnerNames = new ArrayList<>();
    }

    private int findMaxDistance(List<Car> cars) {
        return cars.stream().mapToInt(car -> car.getDistance())
                .max().orElse(0);
    }

    public void makeWinnerNames(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        winnerNames = cars.stream().filter(car -> car.getDistance() == maxDistance)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("%s가 최종 우승했습니다.", String.join(", ", winnerNames));
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}

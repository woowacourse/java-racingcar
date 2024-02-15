package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    public String getWinners(List<Car> cars) {
        cars.sort(Collections.reverseOrder());
        int furthestLocation = cars.get(0).getLocation();
        List<Car> winners = cars.stream()
                .filter(car -> car.getLocation() == furthestLocation)
                .toList();

        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "", "가 최종 우승했습니다."));
    }
}

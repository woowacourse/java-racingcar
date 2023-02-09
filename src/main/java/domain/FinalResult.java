package domain;

import java.util.*;
import java.util.stream.Collectors;

public class FinalResult {
    public List<String> findWinners(List<Car> carsInfo) {
        Integer maxDistance = findMaxDistance(carsInfo);
        return carsInfo.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private Integer findMaxDistance(List<Car> carsInfo) {
        return carsInfo.stream().mapToInt(Car::getDistance).max().orElseThrow(NoSuchFieldError::new);
    }
}

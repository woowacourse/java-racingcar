package domain;

import java.util.*;

public class FinalResult {
    public List<String> findWinners(List<Car> carsInfo) {
        ArrayList<String> winners = new ArrayList<>();
        Integer maxDistance = findMaxDistance(carsInfo);
        for (Car car : carsInfo) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private Integer findMaxDistance(List<Car> carsInfo) {
        return carsInfo.stream().mapToInt(Car::getDistance).max().orElseThrow(NoSuchFieldError::new);
    }
}

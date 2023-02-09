package domain;

import util.RandomNumberGenerator;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsInfo {

    private final List<Car> carsInfo;

    public CarsInfo(List<Car> carsInfo) {
        this.carsInfo = carsInfo;
    }

    public List<String> findWinners() {
        Integer maxDistance = findMaxDistance();
        return carsInfo.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private Integer findMaxDistance() {
        return carsInfo.stream()
                .mapToInt(Car::getDistance)
                .max().
                orElseThrow(NoSuchFieldError::new);
    }

    public void progressRound(RandomNumberGenerator randomNumberGenerator, RoundResult roundResult) {
        for (Car car : carsInfo) {
            Integer randomNumber = randomNumberGenerator.generateRandomNumber();
            boolean movingResult = roundResult.isGo(randomNumber);
            car.move(movingResult);
        }
    }

    public List<Car> getCarsInfo() {
        return Collections.unmodifiableList(carsInfo);
    }
}

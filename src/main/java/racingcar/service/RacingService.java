package racingcar.service;

import racingcar.domain.Car;
import racingcar.utils.RandomIntegerGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingService {
    private static final String INVALID_GET_WINNERS_ERROR_MESSAGE = "우승자 파악 과정에서 에러가 발생했습니다.";

    private final int START_RANDOM_NUMBER = 0;
    private final int END_RANDOM_NUMBER = 9;
    private final List<Car> cars;

    public RacingService() {
        cars = new ArrayList<>();
    }

    public RacingService(List<Car> cars) {
        this.cars = cars;
    }

    public void generateCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> findWinners() {
        return cars.stream()
            .filter(car -> car.getPosition() == findMaxPosition())
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException(INVALID_GET_WINNERS_ERROR_MESSAGE));
    }

    public List<Car> raceRound() {
        cars.forEach((car) -> car.proceed(RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER)));
        return cars;
    }
}

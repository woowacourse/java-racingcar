package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarsInOneRace {
    private final List<Car> cars;

    public CarsInOneRace(List<String> carNames) {
        checkNullNameList(carNames);
        this.cars = createCarsByNames(carNames);
    }

    private void checkNullNameList(List<String> carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(
                "경주에 참여할 자동차가 한 대 이상 존재해야 합니다."
            );
        }
    }

    private List<Car> createCarsByNames(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumber.getRandomNumber()));
    }

    public List<Car> getWinners() {
        final int maxDistance = getMaxDistance();

        return cars.stream()
            .filter(car -> car.isWinner(maxDistance))
            .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}

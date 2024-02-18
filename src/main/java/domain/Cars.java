package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> racingCars;

    public Cars(final List<Car> racingCars) {
        validateCars(racingCars);
        this.racingCars = racingCars;
    }

    private static void validateCars(final List<Car> racingCars) {
        Set<Car> distinctCars = new HashSet<>(racingCars);
        if (racingCars.size() != distinctCars.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    // TODO [LTH]: 인터페이스 사용해 리팩토링
    public List<Car> updateRaceRound() {
        racingCars.forEach(car -> car.moveForward(NumberGenerator.generateRandomNumber()));
        return racingCars;
    }

    // TODO [LTH]: 연산 수 줄이기
    public List<Car> getWinners(final int maxDistance) {
        return racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    public int getMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }
}

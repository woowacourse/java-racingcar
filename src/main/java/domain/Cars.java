package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String DASH = "-";

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

    private static String generateResult(final Car car) {
        return String.join(" : ", car.getCarName(), DASH.repeat(car.getDistance()));
    }

    public void updateRaceRound() {
        racingCars.forEach(car -> car.moveForward(NumberGenerator.generateRandomNumber()));
    }

    public String getRoundResult() {
        return racingCars.stream()
                .map(Cars::generateResult)
                .collect(Collectors.joining("\n"));
    }

    // TODO [LTH]: 연산 수 줄이기
    public String getWinners(final int maxDistance) {
        return racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    public int getMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }
}

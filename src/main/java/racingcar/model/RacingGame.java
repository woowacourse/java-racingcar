package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RacingGame {

    private static final int MINIMUM_TRY_COUNT = 1;

    private final List<Car> cars;
    private final int numberOfRaces;
    private List<RaceResult> raceResults;

    public RacingGame(List<Car> cars, int numberOfRaces) {
        validateNumberOfRaces(numberOfRaces);
        this.cars = cars;
        this.numberOfRaces = numberOfRaces;
        this.raceResults = new ArrayList<>();
    }

    public List<RaceResult> startRace() {
        for (int i = 0; i < numberOfRaces; i++) {
            raceResults.add(moveCars());
        }
        return raceResults;
    }

    public List<Car> selectWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .toList();
    }

    private RaceResult moveCars() {
        Map<String, Integer> raceResult = new LinkedHashMap<>();
        for (Car car : cars) {
            car.move(generateRandomNumber());
            raceResult.put(car.getName(), car.getPosition());
        }
        return new RaceResult(raceResult);
    }

    private int generateRandomNumber() {
        return new Random().nextInt(10);
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private void validateNumberOfRaces(int numberOfRaces) {
        if (numberOfRaces < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("[ERROR] 경주 횟수는 최소 1회 이상 입력해주세요.");
        }
    }
}

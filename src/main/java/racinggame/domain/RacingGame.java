package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MIN_CARS_SIZE = 2;

    private final List<Car> cars;
    private final MoveCondition moveCondition;
    private final List<RoundResult> results = new ArrayList<>();

    private RacingGame(List<Car> cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public static RacingGame of(List<Car> cars, MoveCondition moveCondition) {
        checkCarsSize(cars);
        checkCarsDuplicated(cars);

        return new RacingGame(cars, moveCondition);
    }

    private static void checkCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new RuntimeException();
        }
    }

    private static void checkCarsDuplicated(List<Car> cars) {
        if (getUniqueSize(cars) != cars.size()) {
            throw new RuntimeException();
        }
    }

    private static int getUniqueSize(List<Car> cars) {
        return (int) cars.stream().distinct().count();
    }

    public void race(Round round) {
        while (round.isPlayable()) {
            moveAll();
            results.add(buildRoundResult());
            round = round.decrease();
        }
    }

    private void moveAll() {
        cars.forEach(car -> car.move(moveCondition));
    }

    private RoundResult buildRoundResult() {
        return new RoundResult(cars.stream()
            .map(CarInfo::new)
            .toList());
    }

    public List<String> findWinnerName() {
        return findWinner(findMaxPosition()).stream()
            .map(Car::getName)
            .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compareTo)
            .orElseThrow();
    }

    private List<Car> findWinner(int winnerPosition) {
        return cars.stream()
            .filter(car -> car.isSamePosition(winnerPosition))
            .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<RoundResult> getResult() {
        return results;
    }
}

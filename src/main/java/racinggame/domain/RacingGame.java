package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

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
        if (cars.size() < 2) {
            throw new IllegalArgumentException(
                    String.format("자동차 게임을 진행하기 위해서는 최소 2대 이상 필요합니다. 현재 입력한 자동차 수: %d", cars.size()));
        }
    }

    private static void checkCarsDuplicated(List<Car> cars) {
        if (getUniqueSize(cars) != cars.size()) {
            throw new IllegalArgumentException(String.format("고유한 자동차 이름만 입력 가능합니다."));
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

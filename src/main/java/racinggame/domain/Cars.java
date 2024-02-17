package racinggame.domain;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int MIN_RACING_CARS_SIZE = 2;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::createDefaultPositionCar)
                .toList();
        checkCarsSize(cars);
        checkCarsDuplicated(cars);

        return new Cars(cars);
    }

    private static void checkCarsSize(List<Car> cars) {
        if (cars.size() < MIN_RACING_CARS_SIZE) {
            throw new IllegalArgumentException(
                    String.format("자동차 게임을 진행하기 위해서는 최소 2대 이상 필요합니다. 현재 입력한 자동차 수: %d", cars.size()));
        }
    }

    private static void checkCarsDuplicated(List<Car> cars) {
        if (getUniqueSize(cars) != cars.size()) {
            throw new IllegalArgumentException("고유한 자동차 이름만 입력 가능합니다.");
        }
    }

    private static int getUniqueSize(List<Car> cars) {
        return (int) cars.stream().distinct().count();
    }

    public void moveAll(MoveCondition moveCondition) {
        cars.forEach(car -> car.move(moveCondition));
    }

    public RoundResult buildRoundResult() {
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
        return Collections.unmodifiableList(cars);
    }
}

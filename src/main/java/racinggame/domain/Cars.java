package racinggame.domain;

import java.util.List;

class Cars {

    private static final int MIN_CARS_SIZE = 2;

    private final List<Car> cars;
    private final MoveCondition moveCondition;

    public Cars(List<Car> cars, MoveCondition moveCondition) {
        checkCarsSize(cars);
        checkCarsDuplicated(cars);

        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    private void checkCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCarsDuplicated(List<Car> cars) {
        if (getUniqueSize(cars) != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    private int getUniqueSize(List<Car> cars) {
        return (int) cars.stream().distinct().count();
    }

    public void moveAll() {
        cars.forEach(car -> car.move(moveCondition));
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

    public RoundResult buildRoundResult() {
        return new RoundResult(cars.stream()
            .map(CarInfo::new)
            .toList());
    }
}

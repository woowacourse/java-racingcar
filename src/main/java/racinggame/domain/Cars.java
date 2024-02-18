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
            throw new IllegalArgumentException(String.format("최소 %d대의 자동차를 입력해주세요.", MIN_CARS_SIZE));
        }
    }

    private void checkCarsDuplicated(List<Car> cars) {
        if (getUniqueSize(cars) != cars.size()) {
            throw new IllegalArgumentException("중복된 이름의 자동차가 포함되어 있습니다.");
        }
    }

    private int getUniqueSize(List<Car> cars) {
        return (int) cars.stream().distinct().count();
    }

    public void moveAll() {
        cars.forEach(car -> car.move(moveCondition));
    }

    public List<Car> findWinners() {
        return findWinners(findFirstWinner());
    }

    private Car findFirstWinner() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow();
    }

    private List<Car> findWinners(Car winner) {
        return cars.stream()
            .filter(car -> car.isRival(winner))
            .toList();
    }

    public RoundResult buildRoundResult() {
        return new RoundResult(cars.stream()
            .map(CarInfo::new)
            .toList());
    }
}

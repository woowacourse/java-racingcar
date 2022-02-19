package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;
import racingcar.domain.vo.Name;
import racingcar.domain.vo.MovingNumber;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Name> names) {
        this.cars = convertNamesToCars(names);
    }

    public void move(Queue<MovingNumber> movingNumbers) {
        validateSize(movingNumbers.size());
        for (Car car : cars) {
            car.advance(movingNumbers.poll().value());
        }
    }

    public Winners findWinners() {
        return new Winners(findCoWinners(findWinner()));
    }

    public List<Car> getCars() {
        return this.cars.stream()
            .map(Car::newInstance)
            .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return this.cars.size();
    }

    private List<Car> convertNamesToCars(List<Name> names) {
        return names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void validateSize(int size) {
        if (cars.size() != size) {
            throw new IllegalArgumentException("자동차와 랜덤한 숫자들의 갯수가 일치하지 않습니다.");
        }
    }

    private Car findWinner() {
        return cars.stream()
            .max(Car::comparePosition)
            .orElseThrow(NoSuchElementException::new);
    }

    private List<Name> findCoWinners(Car firstCar) {
        return cars.stream()
            .filter(car -> car.isEqualPosition(firstCar))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

}

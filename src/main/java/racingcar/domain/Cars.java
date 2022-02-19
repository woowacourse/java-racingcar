package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;
import racingcar.vo.CarValue;
import racingcar.domain.vo.Name;
import racingcar.dto.Winners;
import racingcar.domain.vo.MovingNumber;

public class Cars {
    private List<Car> cars;

    public Cars(List<Name> names) {
        this.cars = convertNamesToCars(names);
    }

    public void move(Queue<MovingNumber> movingNumbers) {
        validateSize(movingNumbers.size());
        for (Car car : cars) {
            car.advance(movingNumbers.poll().value());
        }
    }

    public Winners pickMoreWinners() {
        return pickMoreWinners(findFirstCar());
    }

    public List<CarValue> getCars() {
        return this.cars.stream()
            .map(this::carToCarValue)
            .collect(Collectors.toList());
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

    private Car findFirstCar() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

    private Winners pickMoreWinners(Car firstCar) {
        return new Winners(cars.stream()
            .filter(car -> car.isEqualPosition(firstCar))
            .map(Car::getName)
            .collect(Collectors.toList()));
    }

    private CarValue carToCarValue(Car car) {
        return CarValue.create(car.getName().toString(), car.getPosition());
    }
}

package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;
import racingcar.dto.CarValue;
import racingcar.vo.Name;
import racingcar.dto.Winners;
import racingcar.vo.MovingNumber;

public class Cars {
    private List<Car> cars;

    public Cars(List<Name> names) {
        this.cars = convertNamesToCars(names);
    }

    private List<Car> convertNamesToCars(List<Name> names) {
        return names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move(Queue<MovingNumber> movingNumbers) {
        validateSize(movingNumbers.size());
        for (Car car : cars) {
            car.advance(movingNumbers.poll().value());
        }
    }

    private void validateSize(int size) {
        if (cars.size() != size) {
            throw new IllegalArgumentException("자동차와 랜덤한 숫자들의 갯수가 일치하지 않습니다.");
        }
    }

    public Winners getWinners() {
        return pickWinners(getMaxPosition());
    }

    private int getMaxPosition() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow(NoSuchElementException::new)
            .getPosition();
    }

    private Winners pickWinners(int maxPosition) {
        return new Winners(cars.stream()
            .filter(car -> car.isEqualPosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList()));
    }

    public List<CarValue> getCars() {
        return this.cars.stream()
            .map(car -> new CarValue(car.getName().toString(), car.getPosition()))
            .collect(Collectors.toList());
    }

    public int size() {
        return this.cars.size();
    }
}

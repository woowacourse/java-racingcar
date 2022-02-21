package racingcar.domain;

import java.util.Collections;
import java.util.List;
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

    public List<Name> findWinners() {
        return new Winner(cars).findWinners();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
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
}

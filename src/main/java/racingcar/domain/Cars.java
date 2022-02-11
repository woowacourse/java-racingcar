package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;
import racingcar.vo.CarValue;
import racingcar.vo.Name;
import racingcar.vo.Winners;

public class Cars {
    private static final int RANDOM_NUMBER_RANGE = 9 + 1;

    private List<Car> cars;

    public Cars(List<Name> names) {
        this.cars = convertNamesToCars(names);
    }

    private List<Car> convertNamesToCars(List<Name> names) {
        return names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.advance(RandomUtil.getNumbersInRange(RANDOM_NUMBER_RANGE)));
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
}

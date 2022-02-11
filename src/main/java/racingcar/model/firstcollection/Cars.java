package racingcar.model.firstcollection;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import racingcar.model.RandomUtil;
import racingcar.model.vo.Car;
import racingcar.model.vo.Name;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Name> names) {
        this.cars = convertNamesToCars(names);
    }

    private List<Car> convertNamesToCars(List<Name> names) {
        return names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.advance(RandomUtil.getNumbersInRange(10)));
    }

    public List<Name> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow(NoSuchElementException::new)
            .getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.vo.Name;
import racingcar.util.RandomUtil;

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

    public void move() {
        cars.forEach(car -> car.advance(RandomUtil.getNumbersInRange(10)));
    }

    public List<Name> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .max(Comparator.comparing(Car::getPosition))
            .orElseThrow(NoSuchElementException::new)
            .getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

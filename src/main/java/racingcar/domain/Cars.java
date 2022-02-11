package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;
import racingcar.vo.Name;

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

    public List<Name> race(int trials) {
        for (int round = 0; round < trials; round++) {
            move();
        }
        return getWinner(getMaxPosition());
    }

    private void move() {
        cars.forEach(car -> car.advance(RandomUtil.getNumbersInRange(10)));
    }

    private List<Name> getWinner(int maxPosition) {
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
}

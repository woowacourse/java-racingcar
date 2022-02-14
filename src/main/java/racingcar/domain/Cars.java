package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import racingcar.utils.Validator;

public class Cars {
    private static final String DELIMITER = ",";

    private MoveStrategy moveStrategy = new RandomMoveStrategy();
    private final List<Car> cars;

    public Cars(final String input) {
        Validator.checkInput(input);
        this.cars = makeCars(input);
    }

    protected Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> makeCars(final String input) {
        final String[] carNames = input.split(DELIMITER);

        return Arrays.stream(carNames).map(CarName::new).map(Car::new).collect(toList());
    }

    public void playRound() {
        for (final Car car : cars) {
            car.attemptToMove(moveStrategy.isMove());
        }
    }

    public List<Car> findWinners() {
        final Car maxPositionCar = getMaxPositionCar();
        return cars.stream().filter(car -> car.isSamePositionWith(maxPositionCar))
            .collect(toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream().max(Car::compareTo).orElseThrow(NoSuchElementException::new);
    }

    public List<Car> get() {
        return cars;
    }

    public void setMoveStrategy(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}

package racing.domain;

import racing.domain.name.CarName;
import racing.domain.name.CarNames;
import racing.domain.number.Position;
import racing.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Cloneable {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int MINIMUM_CAR_SIZE = 2;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        List<Car> copy = new ArrayList<>(cars);
        validateCars(copy);
        this.cars = copy;
    }
    private void validateCars(List<Car> cars) {
        if (cars.size() < MINIMUM_CAR_SIZE) {
            throw new IllegalArgumentException("자동차는 1개 이상이어야 합니다");
        }
    }

    public static Cars generate(final CarNames inputCarNames) {
        List<CarName> carNames = inputCarNames.getCarNames();
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    @Override
    protected Cars clone() {
        Cars copy = null;
        try {
            copy = (Cars) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

    public void race() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber(START_NUMBER, END_NUMBER)));
    }

    public Winners findWinners() {
        Position maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
        return new Winners(winners);
    }

    private Position getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(IllegalStateException::new)
                .getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getSize() {
        return cars.size();
    }
}

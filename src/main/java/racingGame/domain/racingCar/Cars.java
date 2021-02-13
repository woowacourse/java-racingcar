package racingGame.domain.racingCar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingGame.domain.utils.RandomUtils;
import racingGame.domain.validator.CarsValidator;

public class Cars {
    private static final int INJECTION_NUMBER_MIN = 0;
    private static final int INJECTION_NUMBER_MAX = 9;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        CarsValidator.checkIsValidCars(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    public static Cars createByNames(final List<Name> names) {
        CarsValidator.checkIsValidNames(names);

        List<Car> cars = names.stream()
                .map(Car::createByName)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public void tryMoveCars() {
        this.cars.forEach(car -> car.tryToMove(injectRand()));
    }

    protected int injectRand() {
        return RandomUtils.nextInt(INJECTION_NUMBER_MIN, INJECTION_NUMBER_MAX);
    }

    public List<CarDto> getResults() {
        return this.cars.stream()
                .map(Car::getStatus)
                .collect(Collectors.toList());
    }

    public List<Name> getWinnerNames() {
        return getWinners().getCarsNames();
    }

    private List<Name> getCarsNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Cars getWinners() {
        int winnerPosition = findWinnerPosition();

        List<Car> winners = cars.stream()
                .filter(car -> car.isOnPosition(winnerPosition))
                .collect(Collectors.toList());

        return new Cars(winners);
    }

    private int findWinnerPosition() {
        return cars.stream()
                .map(Car::getStatus)
                .mapToInt(CarDto::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("There isn't winner"));
    }

    public boolean contains(final Car car) {
        return this.cars.contains(car);
    }

    public int size() {
        return cars.size();
    }
}

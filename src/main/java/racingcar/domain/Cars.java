package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.utils.RandomUtils;
import racingcar.domain.validator.CarsValidator;

public class Cars {
    private static final int INJECTION_NUMBER_MIN = 0;
    private static final int INJECTION_NUMBER_MAX = 9;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        CarsValidator.checkIsValidCars(cars);
        this.cars = cars;
    }

    public static Cars createByNames(final List<Name> names) {
        List<Car> cars = names.stream()
                .map(name -> Car.createByName(name))
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public void tryMoveCars() {
        this.cars.forEach(car -> car.tryToMove(injectNumber()));
    }

    public int injectNumber() {
        return RandomUtils.nextInt(INJECTION_NUMBER_MIN, INJECTION_NUMBER_MAX);
    }

    public List<RaceResultDTO> getResults() {
        return this.cars.stream()
                .map(Car::getRaceResults)
                .collect(Collectors.toList());
    }

    public String[] getWinnerNames() {
        int winnerPosition = findWinnerPosition();

        String[] names = cars.stream()
                .filter(car -> car.isOnPosition(winnerPosition))
                .map(Car::toString)
                .toArray(String[]::new);

        return names;
    }

    private int findWinnerPosition() {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            max = car.getFatherPosition(max);
        }

        return max;
    }

    // XXX :: 테스트만을 위한 메소드
    public boolean contains(final Car car) {
        return this.cars.contains(car);
    }
}

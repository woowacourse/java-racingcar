package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.validator.CarsValidator;

public class Cars {
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
        this.cars.forEach(Car::tryToMove);
    }

    public List<RaceResultDTO> getAllResults() {
        return this.cars.stream()
                .map(Car::getRaceResults)
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            max = car.getFatherPosition(max);
        }

        return max;
    }

    public String[] getWinners() {
        int winnerPosition = findWinnerPosition();
        return this.cars.stream()
                .filter(car -> car.isOnPosition(winnerPosition))
                .map(Car::getName)
                .toArray(String[]::new);
    }

    // XXX :: 테스트만을 위한 메소드
    public boolean contains(final Car car) {
        return this.cars.contains(car);
    }
}

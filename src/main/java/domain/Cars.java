package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        checkCarsHasDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void checkCarsHasDuplicate(List<Car> cars) {
        final long nonDuplicateNameCountInCars = cars.stream()
                .distinct()
                .count();
        if (nonDuplicateNameCountInCars != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }

    public void tryMoveOneTime(NumberPicker numberPicker) {
        for (final Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
    }

    public List<Car> getWinners() {
        final Car winner = Collections.max(cars, Car::compareTo);
        return cars.stream()
                .filter(car -> car.samePosition(winner))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getStatuses() {
        return Collections.unmodifiableList(cars);
    }
}

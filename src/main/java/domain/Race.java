package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        checkCarsHasDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void checkCarsHasDuplicate(List<Car> cars) {
        long nonDuplicateNameCountInCars = cars.stream()
                .map(Car::getName)
                .distinct().count();
        if (nonDuplicateNameCountInCars != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }

    public void tryMoveOneTime(NumberPicker numberPicker) {
        for (Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
    }

    public List<Car> getWinners() {
        Car winner = Collections.max(cars, Comparator.comparingInt(Car::getPosition));
        return cars.stream()
                .filter(car -> Comparator.comparingInt(Car::getPosition).compare(car, winner) == 0)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getStatuses() {
        return Collections.unmodifiableList(cars);
    }
}

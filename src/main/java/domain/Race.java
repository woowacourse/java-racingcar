package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private int tryTime;

    public Race(final List<Car> cars) {
        checkCarsHasDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    public void initTryTime(final int tryTime) {
        validateTryTime(tryTime);
        this.tryTime = tryTime;
    }
    
    private void validateTryTime(final int tryTime) {
        if (tryTime < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
    }

    private void checkCarsHasDuplicate(final List<Car> cars) {
        long nonDuplicateNameCountInCars = cars.stream()
                .map(Car::getName)
                .distinct().count();
        if (nonDuplicateNameCountInCars != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }

    public boolean canRace() {
        return tryTime > 0;
    }

    public void tryMoveOneTime(final NumberPicker numberPicker) {
        for (Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
        tryTime--;
    }

    public List<Car> getWinners() {
        final Car winner = Collections.max(cars, Comparator.comparingInt(Car::getPosition));
        return cars.stream()
                .filter(car -> Comparator.comparingInt(Car::getPosition).compare(car, winner) == 0)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getStatuses() {
        return Collections.unmodifiableList(cars);
    }

}

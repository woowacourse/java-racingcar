package domain;

import java.util.ArrayList;
import java.util.Collections;
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
        if (isNegative(tryTime)) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
    }

    private static boolean isNegative(final int tryTime) {
        return tryTime < 0;
    }

    private void checkCarsHasDuplicate(final List<Car> cars) {
        final long nonDuplicateNameCountInCars = cars.stream()
                .distinct().count();
        if (nonDuplicateNameCountInCars != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }

    public boolean canRace() {
        return tryTime > 0;
    }

    public void tryMoveOneTime(final NumberPicker numberPicker) {
        for (final Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
        tryTime--;
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

package domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private int tryTime;

    public Race(final List<Car> cars) {
        checkCarsHasDuplicate(cars);
        this.cars = new Cars(cars);
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
        cars.tryMoveOneTime(numberPicker);
        tryTime--;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getStatuses() {
        return cars.getStatuses();
    }
}

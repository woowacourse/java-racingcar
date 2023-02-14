package domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private TryTime tryTime;

    public Race(final List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public void initTryTime(final int tryTime) {
        if (this.tryTime != null) {
            throw new IllegalStateException("시도횟수는 이미 초기화되어 있습니다.");
        }
        this.tryTime = new TryTime(tryTime);
    }

    public boolean canRace() {
        return tryTime.isRemain();
    }

    public void tryMoveOneTime(final NumberPicker numberPicker) {
        cars.tryMoveOneTime(numberPicker);
        tryTime.decrease();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getStatuses() {
        return cars.getStatuses();
    }
}

package racingcar.domain;

import java.util.List;

public class Circuit {

    private final List<Car> cars;

    public Circuit(final List<Car> cars) {
        this.cars = cars;
    }

    public void startRace() {
        cars.forEach(Car::move);
    }

    public List<CarStatus> getRaceResults() {
        return cars.stream()
                .map(Car::getStatus)
                .toList();
    }

    public List<CarStatus> getWinners(List<CarStatus> result) {
        int maxPosition = getMaxPosition(result);
        return result.stream()
                .filter(carStatus -> carStatus.position() == maxPosition)
                .toList();
    }

    private int getMaxPosition(List<CarStatus> result) {
        return result.stream()
                .mapToInt(CarStatus::position)
                .max()
                .orElse(0);
    }
}

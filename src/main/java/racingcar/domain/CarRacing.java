package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private static final String LINE_CHANGER = "\n";

    private List<Car> cars;

    public CarRacing(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        cars.stream().forEach(Car::move);
    }

    public String convertStatusesToString() {
        return cars.stream()
                .map(Car::convertStatusToString)
                .collect(Collectors.joining(LINE_CHANGER));
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter((car) -> car.isWinner(maxDistance))
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        cars.sort((car1, car2) -> car2.getDistance() - car1.getDistance());
        return cars.get(0).getDistance();
    }
}

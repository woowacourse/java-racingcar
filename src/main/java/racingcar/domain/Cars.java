package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private int maxPosition = 0;

    public Cars(String[] names) {
        cars = new ArrayList<>();
        this.cars.addAll(Arrays.stream(names)
                .map(name -> new Car(name, new RandomNumberRule()))
                .collect(Collectors.toList()));
    }

    public void startRace() {
        for (Car car : cars) {
            car.move();
            maxPosition = car.aboveMaxPosition(maxPosition);
        }
    }

    public List<String> getStates() {
        return cars.stream()
                .map(car -> car.toString())
                .collect(Collectors.toList());
    }

    public List<String> showWinners() {
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
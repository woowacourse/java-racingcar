package racingcar.domain;

import racingcar.domain.data.Car;

import java.util.*;
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

    public Map<String, Integer> getStates() {
        Map<String, Integer> states = new HashMap<>();
        for (Car car : cars) {
            states.put(car.getName(), car.getPosition());
        }
        return states;
    }

    public List<String> showWinners() {
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
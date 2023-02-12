package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final int FIRST_INDEX = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public void moveCars(ValueGenerator valueGenerator, Rule rule) {
        for (Car car : cars) {
            car.moveWith(valueGenerator.generate(), rule);
        }
    }

    public Map<String, Integer> getRoundResult() {
        Map<String, Integer> currentRoundResult = new LinkedHashMap<>();
        for (Car car : cars) {
            currentRoundResult.put(car.getName(), getPosition(car));
        }
        return currentRoundResult;
    }

    public int getCurrentRound() {
        return cars.get(FIRST_INDEX).getTurnCount();
    }

    public List<String> getWinners() {
        Set<Integer> positions = new HashSet<>();
        cars.forEach(car -> positions.add(getPosition(car)));
        int maxPosition = Collections.max(positions);
        return cars.stream().filter(car -> getPosition(car) == maxPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getPosition(Car car) {
        return car.getPosition();
    }
}

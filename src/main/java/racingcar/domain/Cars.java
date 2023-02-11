package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.constant.ErrorLog;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    private final int FIRST_INDEX = 0;

    public void add(Car car) {
        cars.add(car);
    }

    public void addNextCarValue(int value) {

        if (isRoundOver()) {
            cars.get(FIRST_INDEX).addValue(value);
            return;
        }
        getCurrentTurnCar().get().addValue(value);
    }

    public boolean isRoundOver() {
        return getCurrentTurnCar().isEmpty();

    }

    private Optional<Car> getCurrentTurnCar() {
        int size = cars.get(FIRST_INDEX).getLogSize();
        Optional<Car> targetCar = cars.stream().filter(car -> car.getLogSize() < size)
            .findFirst();

        return targetCar;
    }

    public Map<String, Integer> getRoundResult() {
        Map<String, Integer> currentRoundResult = new LinkedHashMap<>();
        for (Car car : cars) {
            currentRoundResult.put(car.getName(), getPosition(car));
        }
        return currentRoundResult;
    }

    public int getTurnCount() {
        if (!isRoundOver()) {
            throw new IllegalStateException(ErrorLog.ROUND_NOT_OVER.getMessage());
        }
        return cars.get(FIRST_INDEX).getLogSize();
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
        return car.getPosition(Rule.MOVING_FORWARD_STANDARD.getStep(), Rule.MOVING_FORWARD_STANDARD.getThreshold());
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int BOUND = 10;
    private static final String COMMA_SPACE = ", ";

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(Random random) {
        for (Car car : cars) {
            car.move(random.nextInt(BOUND));
        }
    }

    public String getWinners() {
        HashMap<Integer, List<String>> carPositionHashMap = new HashMap<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = findWinnerPosition(car, carPositionHashMap, maxPosition);
        }
        List<String> winners = carPositionHashMap.get(maxPosition);
        return getWinnerNames(winners);
    }

    private int findWinnerPosition(Car car, HashMap<Integer, List<String>> carPositionHashMap,
        int maxPosition) {
        initCarPositionHashMap(car, carPositionHashMap);
        carPositionHashMap.get(car.getPosition()).add(car.getName());
        if (maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }

    private void initCarPositionHashMap(Car car, HashMap<Integer, List<String>> carPositionHashMap) {
        if (!carPositionHashMap.containsKey(car.getPosition())) {
            carPositionHashMap.put(car.getPosition(), new ArrayList<>());
        }
    }

    private String getWinnerNames(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            sb.append(COMMA_SPACE);
            sb.append(winners.get(i));
        }
        return sb.toString();
    }
}
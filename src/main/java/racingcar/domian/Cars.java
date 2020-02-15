package racingcar.domian;

import racingcar.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private static final int CAR_LIMIT = 5;
    private static final String DELIMITER = ",";

    public Cars(String inputNames) {
        inputNames = StringUtils.validNullOrEmpty(inputNames);

        String[] names = inputNames.split(DELIMITER);
        validCarCount(names);

        List<Car> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Car(name));
        }
        this.cars = players;
    }

    public List<Car> getCars() {
        return cars;
    }

    private static void validCarCount(String[] names) {
        if (names.length > CAR_LIMIT) {
            throw new IllegalArgumentException("자동차 5대 초과입니다!");
        }
    }

    public int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.moveByRandom(RandomNumberGenerator.generateRandom());
        }
    }

    public String getResult() {
        List<String> winners = new ArrayList<>();
        int max = findMaxPosition();
        for (Car car : cars) {
            winners.add(car.isWinner(max));
        }
        return winners.stream().filter(s -> isWinner(s)).collect(Collectors.joining(","));
    }

    private boolean isWinner(String s) {
        return !"".equals(s);
    }
}

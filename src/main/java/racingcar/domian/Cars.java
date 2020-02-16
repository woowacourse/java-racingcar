package racingcar.domian;

import racingcar.domian.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int CAR_LIMIT = 5;
    private static final String DELIMITER = ",";
    private static final String EMPTY_STRING = "";

    private final List<Car> cars;

    public Cars(String inputNames) {
        String[] names = inputNames.split(DELIMITER);
        validateCarCount(names.length);
        List<Car> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Car(name));
        }
        this.cars = players;
    }

    public List<Car> getCars() {
        return cars;
    }

    private static void validateCarCount(int carCount) {
        if (carCount > CAR_LIMIT) {
            throw new IllegalArgumentException("자동차 5대 초과입니다!");
        }
    }

    private static boolean isNotEmpty(String maybeWinner) {
        return !EMPTY_STRING.equals(maybeWinner);
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
            RandomNumber randomNumber = new RandomNumber();
            car.moveByRandom(RandomNumber.generateRandom());
        }
    }

    public String getResult() {
        List<String> winners = new ArrayList<>();
        int max = findMaxPosition();
        for (Car car : cars) {
            winners.add(car.isWinner(max));
        }
        return winners.stream().filter(Cars::isNotEmpty).collect(Collectors.joining(","));
    }
}

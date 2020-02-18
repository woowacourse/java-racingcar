package racingcar.domian;

import racingcar.domian.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITER = ",";
    private static final String CAR_COUNT_STR = "자동차 5대 초과입니다!";
    private static final int CAR_LIMIT = 5;

    private final List<Car> cars;

    public Cars(String inputNames) {
        String[] names = inputNames.split(DELIMITER);
        validateCarCount(names.length);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private static boolean isNotEmpty(String maybeWinner) {
        return !EMPTY_STRING.equals(maybeWinner);
    }

    private static void validateCarCount(int carCount) {
        if (carCount > CAR_LIMIT) {
            throw new IllegalArgumentException(CAR_COUNT_STR);
        }
    }

    public int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition().getDistance());
        }
        return max;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.getPosition().moveByRandom(new RandomNumber());
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

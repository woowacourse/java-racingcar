package racingcar.domian;

import racingcar.domian.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String EMPTY_STRING = "";
    private static final CarFactory carFactory = new CarFactory();

    private final List<Car> cars;

    public Cars(String inputNames) {
        cars = carFactory.createCars(inputNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private static boolean isNotEmpty(String maybeWinner) {
        return !EMPTY_STRING.equals(maybeWinner);
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

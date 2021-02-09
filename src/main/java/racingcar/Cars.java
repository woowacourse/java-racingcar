package racingcar;

import racingcar.utils.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int START = 0;
    private static final int END = 9;

    private static final List<Car> cars = new ArrayList<>();

    private Cars() {
    }

    public static void addCars(List<String> splittedCarNames) {
        CarNameRepository.addCarNames(splittedCarNames);
        CarNameRepository.getCarNames().forEach(carName -> cars.add(new Car(carName)));
    }

    public static void raceOneLap() {
        cars.forEach(car -> car.moveForwardByRandomNumber(RandomUtil.nextInt(START, END)));
    }

    public static List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream().filter(car -> car.isMaxPosition(maxDistance)).map(Car::getCarName).collect(Collectors.toList());
    }

    private static int getMaxDistance() {
        return cars.stream().collect(Collectors.summarizingInt(Car::getPosition)).getMax();
    }
}
